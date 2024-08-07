package com.scm.smartCM.controllers;

import com.scm.smartCM.entities.User;
import com.scm.smartCM.forms.UserForm;

import com.scm.smartCM.helpers.Message;
import com.scm.smartCM.helpers.MessageType;
import com.scm.smartCM.services.UserService;

import jakarta.servlet.http.HttpSession;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home() {
        
        return "home";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home page handler");
        model.addAttribute("name", "Priyanshu");
        model.addAttribute("Github", "https://github.com/priyanshu798");
        return "home";
    }

    // abbout route
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
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,
            HttpSession session) {
        System.out.println("Processing registration");
        // fetch form data
        // UserForm
        System.out.println(userForm);

        // validate form data
        if (rBindingResult.hasErrors()) {
            return "register";
        }

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(false);
        user.setProfilePic(
                "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75");

        User savedUser = userService.saveUser(user);

        System.out.println("user saved :");

        
        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message", message);

        // redirectto login page
        return "redirect:/register";
    }
}
