package com.userservice.services;

import com.userservice.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface userServices {

    User saveUser(User user);

    List<User> getallUser();

    User getUser(String userId);


}
