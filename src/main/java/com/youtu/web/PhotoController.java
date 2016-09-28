package com.youtu.web;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.youtu.common.Constants;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
import com.qiniu.util.Auth;
import com.youtu.common.FaceppUtils;
import com.youtu.entity.Face;
import com.youtu.service.LosterService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.apache.coyote.http11.Constants.a;

/**
 * Created by jiax on 2016/9/22.
 */
@Controller
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private LosterService losterService;

    @RequestMapping("/uploadPic")
    @ResponseBody
    public void uploadPicture(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws ServletException, IOException {
        //request.setCharacterEncoding("utf-8");

        //创建你要保存的文件的路径
        String path = request.getSession().getServletContext().getRealPath("img");
        //获取该文件的文件名
        String fileName = file.getOriginalFilename();

        fileName = "temp" + fileName.substring(fileName.lastIndexOf("."));
        //System.out.println(path);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // 保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将该文件的路径给客户端，让其可以请求该图片
        //model.addAttribute("fileUrl", request.getContextPath() + "/lupload/"+ fileName);

        return;
    }

    @RequestMapping("/checkPic")
    @ResponseBody
    public String checkPicture() throws FaceppParseException, JSONException {
        //Map<String, Object> jsonMap1 = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject();
        //System.out.println("Start");
        String img = "/usr/tomcat8/webapps/youtu/img/temp.jpg";
//        String img = "E:\\IDEA\\YouTu\\target\\youtu\\img\\temp.jpg";
        File file = new File(img);
        Face face1 = FaceppUtils.detectImg(file);

        List<String> list = losterService.getUrl(face1.getAge(), face1.getGender());
        int length = list.size();

        //jsonMap1.put("ListLength",length);
        //jsonMap1.put("SourceFace",face1);
        jsonObject.put("ListLength", length);
        jsonObject.put("SourceFace", face1);
        //System.out.println(jsonMap1);

        //JSONObject jsonObject2 = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < length; i++) {
            Face face2 = FaceppUtils.detectUrl(list.get(i));
            if (face2 == null) continue;
            HttpRequests httpRequests = new HttpRequests(Constants.API_Key, Constants.API_Secret, true, true);

            PostParameters postParameters = new PostParameters().setFaceId1(face1.getFaceId());
            postParameters.setFaceId2(face2.getFaceId());
            int similarity = httpRequests.recognitionCompare(postParameters).getInt("similarity");

            face2.setFaceUrl(list.get(i));
            face2.setSimilarity(similarity);
            //jsonMap1.put("TargetFace"+(i+1), face2);
            //jsonObject2.put("TargetFace"+(i+1), face2);
            jsonArray.add(face2);
            //System.out.println(jsonMap);
        }

        jsonObject.put("TargetFace", jsonArray);
        String jsonString = jsonObject.toJSONString();

        return jsonString;
    }

    @RequestMapping("/uploadQiniuPic")
    @ResponseBody
    public void uploadQiniuPicture(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws ServletException, IOException {
        //创建你要保存的文件的路径
        String path = request.getSession().getServletContext().getRealPath("img");
        //获取该文件的文件名
        String originalFileName = file.getOriginalFilename();

        String fileType = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = "temp." + fileType;
        //System.out.println(path);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // 保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String remoteFilePath = fileType + "/" + originalFileName;

        try {
            new UploadManager().put(targetFile, remoteFilePath, Constants.Qiniu_Youtu_Upload_Token);
        } catch (QiniuException e) {
            Response r = e.response;

            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                if (r.bodyString().contains("bad token")) {
                    Auth auth = Auth.create(Constants.Qiniu_ACCESS_KEY, Constants.Qiniu_ACCESS_KEY);
                    Constants.Qiniu_Youtu_Upload_Token = auth.uploadToken("youtu");
                    new UploadManager().put(targetFile, remoteFilePath, Constants.Qiniu_Youtu_Upload_Token);
                }
            } catch (QiniuException e1) {
            }
        }

        return;
    }
}
