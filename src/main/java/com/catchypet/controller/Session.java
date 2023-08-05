package com.catchypet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@Component("session")
public class Session {

    @Autowired
    private HttpSession session;

    public void removeSession() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            System.out.println(session.getAttribute("message"));
            session.removeAttribute("message");
            System.out.println("Say hi");
            System.out.println(session.getAttribute("message"));
        } catch (RuntimeException ex) {
//            log.error("No Request: ", ex);
        }
    }
}