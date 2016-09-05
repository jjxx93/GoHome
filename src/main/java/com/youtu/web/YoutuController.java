package com.youtu.web;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.youtu.entity.Lost;
import com.youtu.entity.User;
import com.youtu.service.LostService;
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
import java.util.List;
import java.util.Map;

/**
 * Created by jiax on 2016/8/23.
 */
@Controller
@RequestMapping("")     //url：/模块/资源/{id}/细分    /seckill/list
public class YoutuController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HttpServletRequest request;

    @Autowired
    private LostService lostService;

    @Autowired
    private UserService userService;

    //获取列表页
    @RequestMapping(value = "/getLostList", method = RequestMethod.GET)
    //String 指定返回的视图页面名称，结合设置的返回地址路径加上页面名称后缀即可访问到
    public String getLostList(Model model) {
        List<Lost> list = lostService.getLostList();
        model.addAttribute("list", list);
        //list.jsp + model = ModelAndView
        return "getLostList";      //  /jsp/getLostList.jsp
    }

    //登录操作
    @RequestMapping(value = "/login")
    @ResponseBody   //直接将返回值输出到页面
    public Map<String, Object> MLogin(User user, HttpSession session)  {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        //获取正确验证码
        String validateCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);

        if (user.getValidateCode().toUpperCase().equals(validateCode)) {
            User rUser = userService.validation(user);
            if (rUser == null) {
                jsonMap.put("msg", "用户名或密码错误");
            } else {
                jsonMap.put("msg", "验证通过");
                jsonMap.put("user", rUser);
                session.setAttribute("user", rUser);
            }
        } else {
            jsonMap.put("msg", "验证码错误");
        }

        return jsonMap;
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
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

}
