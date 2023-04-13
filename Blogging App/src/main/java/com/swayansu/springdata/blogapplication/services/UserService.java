package com.swayansu.springdata.blogapplication.services;

import com.swayansu.springdata.blogapplication.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user,Integer userId);
    void deleteUser(Integer userId);
}
