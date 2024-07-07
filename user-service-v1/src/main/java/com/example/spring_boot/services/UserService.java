package com.example.spring_boot.services;

import com.example.spring_boot.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User addUser(User user);

    public User getUserById(int userId);

    public User updateUser (User user);

    public User deleteUserById(int id);

}
