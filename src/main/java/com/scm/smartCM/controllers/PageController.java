package com.scm.smartCM.controllers;

import com.scm.smartCM.forms.UserForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home page handler");
        model.addAttribute("name", "Priyanshu");
        model.addAttribute("Github", "https://github.com/priyanshu798");
        return "home";
    }


    //abbout route
    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("About page loading");
        return "about";
    }

    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("Services PAge");
        return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        System.out.println("Services PAge");
        return "services";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("Login PAge");
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        System.out.println("Register PAge");
        return "register";
    }
 
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm) {
        System.out.println("register");
        //fetch form data
        System.out.println(userForm);
        //validate

        //save to db
        
        //msg = reg success
        //regirect login page
        return "redirect:/register";
    }
}
