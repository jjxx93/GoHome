package com.youtu.common;

import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
import com.youtu.entity.Face;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

/**
 * Created by jiax on 2016/9/21.
 */
public class FaceppUtils {
    public static Face detectUrl(String url) throws FaceppParseException, JSONException {
        HttpRequests httpRequests = new HttpRequests(YoutuConstants.API_Key, YoutuConstants.API_Secret, true, true);
        PostParameters postParameters = new PostParameters().setUrl(url);

        JSONObject result = httpRequests.detectionDetect(postParameters);
        if (result.getJSONArray("face").isNull(0)) {
            return null;
        }
        JSONObject faceJson = result.getJSONArray("face").getJSONObject(0);
        JSONObject attributeJson = faceJson.getJSONObject("attribute");
        JSONObject genderJson = attributeJson.getJSONObject("gender");
        JSONObject ageJson = attributeJson.getJSONObject("age");

        int gender = 2;
        String faceId = faceJson.getString("face_id");
        int imgHeight = result.getInt("img_height");
        int imgWidth = result.getInt("img_width");

        if (genderJson.getInt("confidence") > 80) {
            if (genderJson.getString("value").equals("Male")) {
                gender = 0;
            } else {
                gender = 1;
            }
        }

        int age = ageJson.getInt("value");
        int range = ageJson.getInt("range");

        return new Face(faceId, imgHeight, imgWidth, gender, age, range);
    }

    public static Face detectImg(File img) throws FaceppParseException, JSONException {
        HttpRequests httpRequests = new HttpRequests(YoutuConstants.API_Key, YoutuConstants.API_Secret, true, true);
        PostParameters postParameters = new PostParameters().setImg(img);

        JSONObject result = httpRequests.detectionDetect(postParameters);
        if (result.getJSONArray("face").isNull(0)) {
            return null;
        }
        JSONObject faceJson = result.getJSONArray("face").getJSONObject(0);
        JSONObject attributeJson = faceJson.getJSONObject("attribute");
        JSONObject genderJson = attributeJson.getJSONObject("gender");
        JSONObject ageJson = attributeJson.getJSONObject("age");

        int gender = 2;
        String faceId = faceJson.getString("face_id");
        int imgHeight = result.getInt("img_height");
        int imgWidth = result.getInt("img_width");

        if (genderJson.getInt("confidence") > 80) {
            if (genderJson.getString("value").equals("Male")) {
                gender = 0;
            } else {
                gender = 1;
            }
        }

        int maxAge = ageJson.getInt("value") + ageJson.getInt("range");
        int minAge = ageJson.getInt("value") - ageJson.getInt("range");

        return new Face(faceId, imgHeight, imgWidth, gender, maxAge, minAge);
    }

    public static int getSimilarity(String url1, String url2) throws FaceppParseException, JSONException {
        Face face1 = FaceppUtils.detectUrl(url1);
        Face face2 = FaceppUtils.detectUrl(url2);

        HttpRequests httpRequests = new HttpRequests(YoutuConstants.API_Key, YoutuConstants.API_Secret, true, true);;
        PostParameters postParameters = new PostParameters().setFaceId1(face1.getFaceId());
        postParameters.setFaceId2(face2.getFaceId());

        return httpRequests.recognitionCompare(postParameters).getInt("similarity");
    }
}

