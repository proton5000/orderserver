package com.orderserver.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.orderserver.models.Order;
import com.orderserver.models.User;
import com.orderserver.services.OrderService;
import com.orderserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by proton on 27.01.2016.
 */
@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }

//    @ResponseBody
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public User login(@RequestParam ("username") String username, @RequestParam ("password") String password) throws JsonProcessingException {
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

    @ResponseBody
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public ArrayList<Order> addOrder(@RequestParam("login") String login, @RequestParam ("link") String link, @RequestParam ("pcs") Integer pcs, @RequestParam ("comment") String comment) throws IOException {

        return orderService.addOrder(login, link, pcs, comment);
    }

    @ResponseBody
    @RequestMapping(value = "/getOrdersByUser", method = RequestMethod.POST)
    public ArrayList<Order> getOrdersByUser(@RequestParam("login") String login) throws JsonProcessingException {

        return orderService.getOrdersByUserId(login);
    }

}
