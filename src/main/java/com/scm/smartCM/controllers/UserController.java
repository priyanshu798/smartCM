package com.scm.smartCM.controllers;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.smartCM.entities.User;
import com.scm.smartCM.services.UserService;

import ch.qos.logback.classic.Logger;


@Controller
@RequestMapping("/user")
public class UserController {

   

      @Autowired
    private UserService userService;


    //dashboard
    @RequestMapping(value = "/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }

    //profile page
    @RequestMapping("/profile")
    public String userProfile() {
        return "user/profile";
    }
    
}
