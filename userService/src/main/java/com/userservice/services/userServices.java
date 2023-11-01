package com.userservice.services;

import com.userservice.Entity.User;

import java.util.List;

public interface userServices {

    User saveUser(User user);

    List<User> getallUser();

    User getUser(String userId);


}
