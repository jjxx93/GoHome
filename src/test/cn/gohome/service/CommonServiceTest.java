package cn.gohome.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jiax on 2016/11/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class CommonServiceTest {
    @Autowired      //自动注入
    private CommonService commonService;

    @Test
    public void getList() throws Exception {
        JSONArray jsonArray = commonService.getList(3, null, null);

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject);
        }

//        for (Status status:jsonArray) {
//            System.out.println(status);
//        }
    }

    @Test
    public void getList1() throws Exception {

    }

    @Test
    public void getList2() throws Exception {

    }

}