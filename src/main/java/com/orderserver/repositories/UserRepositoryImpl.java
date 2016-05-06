package com.orderserver.repositories;

import com.orderserver.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by proton on 27.01.2016.
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser(String name, String password) {

        return (User) entityManager.createNamedQuery("getUser").setParameter("name", name).setParameter("password", password).getSingleResult();
    }

    @Override
    public void delUser(String email) {

        entityManager.remove(entityManager.createNamedQuery("getUserByEmail").setParameter("email", email).getSingleResult());
    }

    @Override
    public User addUser(User user) {

            entityManager.persist(user);

        return (User) entityManager.createNamedQuery("getUserById").setParameter("id", user.getId()).getSingleResult();
    }
}
