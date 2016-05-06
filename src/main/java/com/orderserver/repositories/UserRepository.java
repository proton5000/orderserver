package com.orderserver.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.orderserver.models.User;

/**
 * Created by proton on 27.01.2016.
 */
public interface UserRepository {

    User getUser(String name, String password);

    User addUser(User user);

    void delUser(String email) throws JsonProcessingException;

}
