package com.orderserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by proton on 27.01.2016.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }

}
