package com.swayansu.springdata.blogapplication.repositories;

import com.swayansu.springdata.blogapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User, Integer> {
}
