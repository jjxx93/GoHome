package com.youtu.service;

import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;
import com.youtu.common.Constants;
import com.youtu.common.FaceppUtils;
import com.youtu.entity.Face;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Year;
import java.util.Calendar;
import java.util.List;

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
    }

    @Test
    public void addLoster() throws Exception {
        System.out.println(losterService.addLoster("2f667d326b7041feac4e2ccf57fc4c84", "孙立鑫", "1993-10-10", "1", 250, "2013-10-10",
                "http://123.456.78", "中国", "无"));
    }
}