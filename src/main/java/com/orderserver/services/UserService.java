package com.orderserver.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.orderserver.models.User;

/**
 * Created by proton on 28.01.2016.
 */
public interface UserService {

    User addUser(String name, String password, String email) throws JsonProcessingException;

    void delUser(String email) throws JsonProcessingException;

    User login(String name, String password) throws JsonProcessingException;
}
