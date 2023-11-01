package com.userservice.repositories;

import com.userservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User,String> {




}
