package com.userservice.services.impl;

import com.userservice.Entity.User;
import com.userservice.exceptions.ResourceNotFoundExceptions;
import com.userservice.repositories.UserRepositories;
import com.userservice.services.userServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class userServiceImpl implements userServices {

    @Autowired
    private UserRepositories userRepositories;

    @Override
    public User saveUser(User user) {
       String ramdomUserId= UUID.randomUUID().toString();
       user.setUserId(ramdomUserId);
        return userRepositories.save(user);
    }

    @Override
    public List<User> getallUser() {
        return userRepositories.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepositories.findById(userId).orElseThrow(()-> new ResourceNotFoundExceptions("User is not find with the id"+userId));
    }
}
