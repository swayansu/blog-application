package com.swayansu.springdata.blogapplication.impl;

import com.swayansu.springdata.blogapplication.payloads.UserDto;
import com.swayansu.springdata.blogapplication.entities.User;
import com.swayansu.springdata.blogapplication.exceptions.ResourceNotFoundException;
import com.swayansu.springdata.blogapplication.repositories.UserRepo;
import com.swayansu.springdata.blogapplication.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", "Id", userId)
                );
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        return users.stream().map(this::userToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto user) {
        User user1 = this.dtoToUser(user);
        User savedUser = this.userRepo.save(user1);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user1 = this.userRepo.findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        user1.setName(userDto.getName());
        user1.setEmail(userDto.getEmail());
        user1.setPassword(userDto.getPassword());
        user1.setAbout(userDto.getAbout());

        User updateUser = this.userRepo.save(user1);

        return this.userToDto(updateUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", userId)
        );
        this.userRepo.delete(user);
    }


    private User dtoToUser(UserDto userDto){
       return this.modelMapper.map(userDto,User.class);
    }

    public UserDto userToDto(User user){
        return this.modelMapper.map(user, UserDto.class);
    }
}
