package com.userservice.controller;

import com.userservice.Entity.User;
import com.userservice.services.userServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {

private userServices userServices;

@PostMapping
public ResponseEntity<User> createUser(@RequestBody User user){
User user1=userServices.saveUser(user);
return ResponseEntity.status(HttpStatus.CREATED).body(user1);


}
@GetMapping("/{userId}")
public ResponseEntity<User> getSingleUser(@PathVariable String userId){
    User user =userServices.getUser(userId);
    return ResponseEntity.ok(user);

}

@GetMapping
public ResponseEntity<List<User>>getAllUser(){
    List<User> allUser = userServices.getallUser();
    return ResponseEntity.ok(allUser);
}

}
