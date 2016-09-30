package com.youtu.web;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.youtu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiax on 2016/8/23.
 */
@Controller
@RequestMapping("")     //url：/模块/资源/{id}/细分    /seckill/list
public class YoutuController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    容器管理
    @Autowired
    HttpServletRequest request;

    @Autowired
    private UserService userService;


    //获取列表页
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    //String 指定返回的视图页面名称，结合设置的返回地址路径加上页面名称后缀即可访问到
    public Map<String, Object> getLost(Model model) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("msg", "验证通过");
        //list.jsp + model = ModelAndView
        return jsonMap;      //  /jsp/getLostList.jsp
    }

    // 获取验证码
    private Producer captchaProducer = null;

    @Autowired
    public void setCaptchaProducer(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }

    @RequestMapping("/getValidateCode")
    public void handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control",
                "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = captchaProducer.createText();
        // store the text in the session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,
                capText);
        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out
        ImageIO.write(bi, "jpeg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

}
