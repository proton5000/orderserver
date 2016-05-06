package com.orderserver.repositories;

import com.orderserver.models.Order;
import com.orderserver.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

/**
 * Created by proton on 04.02.2016.
 */
@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ArrayList<Order> addOrder(Order order) {

        entityManager.persist(order);

        return (ArrayList<Order>) entityManager.createNamedQuery("getOrderByLink").setParameter("link", order.getLink()).getResultList();
    }

    @Override
    public ArrayList<Order> getOrdersByUser(User user) {

        return (ArrayList<Order>) entityManager.createNamedQuery("getOrdersByUserId").setParameter("user", user).getResultList();
    }
}
