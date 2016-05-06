package com.orderserver.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.orderserver.models.Order;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by proton on 04.02.2016.
 */
public interface OrderService {

    ArrayList<Order> addOrder (String login, String link, Integer pcs, String comment) throws IOException;

    ArrayList<Order> getOrdersByUserId (String login) throws JsonProcessingException;

}
