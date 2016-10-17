package com.youtu.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
import com.youtu.common.Constants;
import com.youtu.common.FaceppUtils;
import com.youtu.common.GetUUIDNumber;
import com.youtu.common.Msgs;
import com.youtu.dao.LosterDao;
import com.youtu.entity.Face;
import com.youtu.entity.Loster;
import com.youtu.service.LosterService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by jiax on 2016/9/21.
 */
@Service
public class LosterServiceImpl implements LosterService {
    @Autowired      //自动注入
    private LosterDao losterDao;

    @Override
    public List<String> getUrl(int age, int gender) {
        return losterDao.queryPictureByAgeAndGender(age, String.valueOf(gender));
    }

    @Override
    public boolean addLoster(String userUuid, String losterName, String losterBirthday, String gender, int height, String lostDate,
                             String picture, String lostLocation, String remarks) {
        String losterUuid = GetUUIDNumber.createUUIDNumber();
        int age = Calendar.getInstance().get(Calendar.YEAR) - Integer.valueOf(losterBirthday.substring(0, 4)) + 1;

        Character datasource = '5';     // 用户上传为5

        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss-SSS");
        String updateTime = sd.format(date);
        System.out.println(updateTime);

        if (losterDao.insertLoster(losterUuid, losterName, age, losterBirthday, gender, height, lostDate,
                picture, lostLocation, remarks, datasource, userUuid, updateTime) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Loster> matchLosterByAgeAndGender(int age, int ageRange, int gender) {
        // 计算待查找年龄范围
        int minAge = age - ageRange;
        if (minAge < 1) {
            minAge = 1;
        }   // 最小年龄为1
        int maxAge = age + ageRange;
        if (age <= 5) {
            maxAge = age + age;
        }    // 考虑到年龄越小，判断的年龄范围应越小

        //String genderStr = String.valueOf(gender);
        return losterDao.queryPictureByMaxMinAgeAndGender(minAge, maxAge, String.valueOf(gender));
    }

    @Override
    public JSONObject matchLosterByPictureAgeAndGender(String picture, LosterService losterService) {
        JSONObject jsonObject = new JSONObject();

        try {
            // 分析照片
            Face face1 = FaceppUtils.detectUrl(picture);
            // 根据照片年龄和性别查找数据
            List<Loster> losterList = losterService.matchLosterByAgeAndGender(face1.getAge(), face1.getRange(), face1.getGender());
            //System.out.println(losterList);

            if (losterList.isEmpty()) {       // 数据库中无匹配信息
                jsonObject.put("result", Constants.MATCH_BEFOUNDER_NOLOSTER);
                jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_NOLOSTER);
                return jsonObject;
            } else {
                // 循环检测相关图片相似度
                JSONArray jsonArray = new JSONArray();
                for (Loster loster : losterList) {
                    Face face2 = FaceppUtils.detectUrl(loster.getPicture());
                    if (face2 == null) continue;
                    HttpRequests httpRequests = new HttpRequests(Constants.API_Key, Constants.API_Secret, true, true);

                    PostParameters postParameters = new PostParameters().setFaceId1(face1.getFaceId());
                    postParameters.setFaceId2(face2.getFaceId());

                    int similarity = httpRequests.recognitionCompare(postParameters).getInt("similarity");

                    if (similarity > 50) {          // 只取相似度大于50的值
                        // 添加数据到json对象
                        face2.setLosterUuid(loster.getLosterUuid());
                        face2.setFaceUrl(loster.getPicture());
                        face2.setSimilarity(similarity);
                        jsonArray.add(face2);

                        // 添加数据到match表
                        //matchesService.addMatches(userUuid, uuid, loster.getLosterUuid(), similarity, "0");
                    }
                }

                if (jsonArray == null) {    // 数据库中无相似度大于50的匹配信息
                    jsonObject.put("result", Constants.MATCH_BEFOUNDER_NOLOSTER);
                    jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_NOLOSTER);
                    return jsonObject;
                } else {
                    jsonObject.put("result", Constants.MATCH_BEFOUNDER_SUCCESS);
                    jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_SUCCESS);
                    jsonObject.put("arrayLength", jsonArray.size());
                    jsonObject.put("sourceFace", face1);
                    jsonObject.put("faceArray", jsonArray);
                    return jsonObject;
                }
            }
        } catch (JSONException | FaceppParseException e) {
            e.printStackTrace();
            jsonObject.put("result", Constants.MATCH_BEFOUNDER_FAIL);
            jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_FAIL);
            return jsonObject;
        }

        //return jsonObject;
    }

    @Override
    public List<Loster> getLosterByUserUuid(String userUuid) {
        return losterDao.queryBySourceId(userUuid);
    }

    @Override
    public Loster getLosterByLosterUuid(String losterUuid) {
        return losterDao.queryByLosterUuid(losterUuid);
    }

    @Override
    public Boolean modifyLosterByLosterUuid(String userUuid, String losterUuid, String losterName, String losterBirthday, String gender, int height, String lostDate,
                                            String picture, String lostLocation, String remarks) {
        int age = Calendar.getInstance().get(Calendar.YEAR) - Integer.valueOf(losterBirthday.substring(0, 4)) + 1;

        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss-SSS");
        String updateTime = sd.format(date);
        System.out.println(updateTime);

        if (losterDao.updateLoster(losterUuid, losterName, age, losterBirthday, gender, height, lostDate,
                picture, lostLocation, remarks, userUuid, updateTime) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteLoster(String userUuid, String losterUuid) {
        if (losterDao.deleteLoster(losterUuid, userUuid) > 0) {
            return true;
        }
        return false;
    }
}
