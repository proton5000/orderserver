package com.orderserver.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.orderserver.models.User;
import com.orderserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by proton on 28.01.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(String name, String password, String email) throws JsonProcessingException {

        if ( (email.contains("@") & email.contains(".")) ) {
            return userRepository.addUser(new User().setName(name).setPassword(password).setEmail(email));
        }

        return null;
    }

    @Override
    public void delUser(String email) throws JsonProcessingException {

        //return userRepository.delUser(email);
        userRepository.delUser(email);
    }

    @Override
    public User login(String name, String password) throws JsonProcessingException {

        return userRepository.getUser(name, password);
    }
}

