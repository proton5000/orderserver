package com.orderserver.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.orderserver.models.Order;
import com.orderserver.models.User;
import com.orderserver.repositories.OrderRepository;
import com.orderserver.shops.ShopRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by proton on 04.02.2016.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    CleanLink cleanLink;

    @Autowired
    ShopRouterService shopRouterService;

    @Autowired
    OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ArrayList<Order> addOrder(String login, String link, Integer pcs, String comment) throws IOException {

        try {

            if ( pcs.intValue() == 0 ) {
                pcs = 1;
            }

        } catch (NullPointerException e) {
            pcs = 1;
        }

        User user = (User) entityManager.createNamedQuery("getUserByName").setParameter("name", login).getSingleResult();

        if (link.contains("aliexpress")) {
            link = cleanLink.cleanLink(link);
        }

        Map imgUrlAndName = shopRouterService.imgAndNameOrder(link);

        return orderRepository.addOrder(new Order().setUser(user).setLink(link).setImageUrl(imgUrlAndName.get("imgUrl").toString()).setPcs(pcs).setComment(comment).setName(imgUrlAndName.get("name").toString()));
    }

    @Override
    public ArrayList<Order> getOrdersByUserId(String login) throws JsonProcessingException {

        User user = (User) entityManager.createNamedQuery("getUserByName").setParameter("name", login).getSingleResult();

        return orderRepository.getOrdersByUser(user);
    }
}
