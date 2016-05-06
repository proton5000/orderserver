package com.orderserver.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.orderserver.models.User;
import com.orderserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by proton on 06.05.2016.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

//    @ResponseBody
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public User login(@RequestParam("username") String username, @RequestParam ("password") String password) throws JsonProcessingException {
//        return userService.login(username, password);
//    }

    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addUser(@RequestParam ("username") String username, @RequestParam ("password") String password, @RequestParam ("email") String email) throws JsonProcessingException {
        return userService.addUser(username, password, email);
    }

    @ResponseBody
    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public void delUser(@RequestParam ("email") String email) throws JsonProcessingException {
        userService.delUser(email);
    }

}
