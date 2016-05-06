package com.orderserver.repositories;

import com.orderserver.models.Order;
import com.orderserver.models.User;

import java.util.ArrayList;

/**
 * Created by proton on 04.02.2016.
 */
public interface OrderRepository {

    ArrayList<Order> addOrder(Order order);

    ArrayList<Order> getOrdersByUser(User user);
}
