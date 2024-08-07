package com.scm.smartCM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserCotroller {
    //dashboard
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String userDashboard() {
        return "user/dashboard";
    }

    //profile page
    @RequestMapping(value = "/profile", method=RequestMethod.GET)
    public String userProfile() {
        return "user/profile";
    }
    
}
