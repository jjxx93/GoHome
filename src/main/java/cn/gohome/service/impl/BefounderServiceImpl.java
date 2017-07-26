package cn.gohome.service.impl;

import cn.gohome.common.Constants;
import cn.gohome.common.FaceppUtils;
import cn.gohome.common.GetUUIDNumber;
import cn.gohome.common.Msgs;
import cn.gohome.dao.BefounderDao;
import cn.gohome.dao.MatchesDao;
import cn.gohome.entity.Befounder;
import cn.gohome.entity.Face;
import cn.gohome.service.BefounderService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jiax on 2016/10/2.
 */
@Service
public class BefounderServiceImpl implements BefounderService {
    @Autowired      //自动注入
    private BefounderDao befounderDao;

    @Autowired      //自动注入
    private MatchesDao matchesDao;

    /**
     * 添加流浪者
     * @return
     */
    @Override
    public Boolean addBefounder(String founderUuid, String foundLocation, String foundTime, String picture, int age,
                                int ageRange, String gender, String remarks, String state) {
        String uuid = GetUUIDNumber.createUUIDNumber();

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String updateTime = sd.format(new Date());
        sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = sd.format(new Date());

        return befounderDao.insertBefounder(uuid, founderUuid, foundLocation, foundTime, picture, age, ageRange, gender,
                remarks, state, createTime, updateTime) > 0;
    }

    @Override
    public List<Befounder> getBefounders(String founderUuid) {
        return befounderDao.queryByFounderUuid(founderUuid);
    }

    @Override
    public Befounder getBefounder(String uuid) {
        return befounderDao.queryByUuid(uuid);
    }

    @Override
    public Boolean deleteBefounderAndMatches(String userUuid, String uuid) {
        if (befounderDao.deleteBefounder(uuid, userUuid) > 0) {
            matchesDao.deleteMatches(userUuid, uuid);
            return true;
        }
        return false;
    }

    @Override
    public Boolean modifyBefounder(String uuid, int age, int ageRange, String gender, String remarks, String state) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String currentTime = sd.format(new Date());

        return befounderDao.uploadBefounder(uuid, age, ageRange, gender, remarks, state,
                currentTime) > 0;
    }

    @Override
    public Boolean modifyAgeAndGender(String uuid, int age, int ageRange, String gender, String state) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String currentTime = sd.format(new Date());

        return befounderDao.uploadAgeAndGender(uuid, age, ageRange, gender, state,
                currentTime) > 0;
    }

    @Override
    public List<Befounder> matchBefounderByAgeAndGender(int age, int ageRange, int gender) {
        // 计算待查找年龄范围
        int minAge = age - ageRange;
        int maxAge = age + ageRange;

        if (minAge < 1) {
            minAge = 1;
        }   // 最小年龄为1
        if (age <= 5) {
            maxAge = age + age;
        }    // 考虑到年龄越小，判断的年龄范围应越小

        return befounderDao.queryPictureByMaxMinAgeAndGender(minAge, maxAge, String.valueOf(gender));
    }

    @Override
    public JSONObject matchBefounderByPictureAgeAndGender(String picture, BefounderService befounderService) {
        JSONObject jsonObject = new JSONObject();

        try {
            Face face1 = FaceppUtils.detectUrl(picture);
            List<Befounder> befounderList = befounderService.matchBefounderByAgeAndGender(face1.getAge(), face1.getRange(), face1.getGender());
            //System.out.println(losterList);

            if (befounderList.isEmpty()) {       // 数据库中无匹配信息
                jsonObject.put("result", Constants.MATCH_BEFOUNDER_NOLOSTER);
                jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_NOLOSTER);
                return jsonObject;
            } else {
                // 循环检测相关图片相似度
                JSONArray jsonArray = new JSONArray();
                for (Befounder befounder : befounderList) {
                    Face face2 = FaceppUtils.detectUrl(befounder.getPicture());
                    if (face2 == null) continue;
                    HttpRequests httpRequests = new HttpRequests(Constants.API_Key, Constants.API_Secret, true, true);

                    PostParameters postParameters = new PostParameters().setFaceId1(face1.getFaceId());
                    postParameters.setFaceId2(face2.getFaceId());

                    int similarity = httpRequests.recognitionCompare(postParameters).getInt("similarity");

                    if (similarity > 50) {          // 只取相似度大于50的值
                        // 添加数据到json对象
                        face2.setLosterUuid(befounder.getUuid());
                        face2.setFaceUrl(befounder.getPicture());
                        face2.setSimilarity(similarity);
                        jsonArray.add(face2);

                        // 添加数据到match表
                        //matchesService.addMatches(userUuid, uuid, loster.getLosterUuid(), similarity, "0");
                    }
                }

                if (jsonArray.isEmpty()) {    // 数据库中无相似度大于50的匹配信息
                    jsonObject.put("result", Constants.MATCH_BEFOUNDER_NOGOODLOSTER);
                    jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_NOGOODLOSTER);
                    return jsonObject;
                } else {
                    jsonObject.put("arrayLength", jsonArray.size());
                    jsonObject.put("sourceFace", face1);
                    jsonObject.put("faceArray", jsonArray);
                    jsonObject.put("result", Constants.MATCH_BEFOUNDER_SUCCESS);
                    jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_SUCCESS);

                    return jsonObject;
                }
            }
        } catch (JSONException | FaceppParseException e) {
            e.printStackTrace();
            jsonObject.put("result", Constants.MATCH_BEFOUNDER_FAIL);
            jsonObject.put("msg", Msgs.MATCH_BEFOUNDER_FAIL);
            return jsonObject;
        }
    }
}
