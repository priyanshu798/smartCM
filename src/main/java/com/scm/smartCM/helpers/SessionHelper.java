package com.scm.smartCM.helpers;

import org.apache.catalina.connector.Request;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {
    public static void removeMessage() {
       try { 
        System.out.println("Removing messagge from system");
        HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        session.removeAttribute("message");
    }
    catch (Exception e) {

        System.out.println("Error in SessionHelper:" + e);
        e.printStackTrace();
    }
    }

}
