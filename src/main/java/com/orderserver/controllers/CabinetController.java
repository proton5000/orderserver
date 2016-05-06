package com.orderserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by proton on 05.04.2016.
 */
@Controller
public class CabinetController {

    @RequestMapping(value = "/cab")
    public String cabinet() {
        return "cabinet.html";
    }

}
