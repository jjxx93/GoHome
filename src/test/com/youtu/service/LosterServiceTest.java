package com.youtu.service;

import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
import com.youtu.common.FaceppUtils;
import com.youtu.common.YoutuConstants;
import com.youtu.dao.LosterDao;
import com.youtu.entity.Face;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jiax on 2016/9/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class LosterServiceTest {
    @Autowired      //自动注入
    private LosterService losterService;

    @Test
    public void getUrl() throws Exception {
        //String rootPath = getClass().getResource("../").getFile().toString();
//        String img = "E:\\IDEA\\YouTu\\src\\main\\webapp\\img\\4.jpg";
//        String urlB = "http://www.baobeihuijia.com/photo/water/water_199012.jpg";
//        HttpRequests httpRequests = new HttpRequests(YoutuConstants.API_Key, YoutuConstants.API_Secret, true, true);
//        //PostParameters postParameters = new PostParameters().setUrl(urlB);
//        File file = new File(img);
//        PostParameters postParameters = new PostParameters().setImg(file);
//        System.out.println(httpRequests.detectionDetect(postParameters));
        String urlA = "http://www.baobeihuijia.com/photo/water/water_199375.jpg";

        Face face1 = FaceppUtils.detectUrl(urlA);
        List<String> list = losterService.getUrl(face1.getAge(), face1.getAge(), face1.getGender());
        int length = list.size();

        for (int i = 0; i < length; i++) {
            Face face2 = FaceppUtils.detectUrl(list.get(i));
            if (face2 == null) continue;
            HttpRequests httpRequests = new HttpRequests(YoutuConstants.API_Key, YoutuConstants.API_Secret, true, true);

            PostParameters postParameters = new PostParameters().setFaceId1(face1.getFaceId());
            postParameters.setFaceId2(face2.getFaceId());
            System.out.println(httpRequests.recognitionCompare(postParameters).getInt("similarity"));
        }

    }

}