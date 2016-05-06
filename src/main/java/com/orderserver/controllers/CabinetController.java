package com.orderserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by proton on 05.04.2016.
 */
@Controller
public class CabinetController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/cabinet")
    public String cabinet() {
        return "cabinet";
    }

}
