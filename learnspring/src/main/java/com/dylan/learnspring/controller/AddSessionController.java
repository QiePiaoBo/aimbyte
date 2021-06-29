package com.dylan.learnspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Dylan
 * @Date : 2021/6/29 - 22:26
 * @Description :
 * @Function :
 */
@RestController
@RequestMapping("session")
public class AddSessionController {

    @RequestMapping("/addSessionTest")
    public String addSession(HttpSession session){
        session.setAttribute("aaa", "AAA");
        return "session added.";
    }

}
