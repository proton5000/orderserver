package com.orderserver.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.orderserver.models.Order;
import com.orderserver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by proton on 06.05.2016.
 */

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

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
