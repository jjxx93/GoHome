package com.youtu.web;

import com.youtu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by jiax on 2016/10/2.
 */
@Controller
@RequestMapping("/volunteer")
public class VolunteerController {
    @Autowired
    private UserService userService;


}
