package com.example.spring_boot.controller;

import com.example.spring_boot.exception.UserNotFoundException;
import com.example.spring_boot.model.ApiResponse;
import com.example.spring_boot.entity.User;
import com.example.spring_boot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add/user")
    private User addUser (@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<ApiResponse<User>> getUserById (@PathVariable("id") String id) {
        User user = userService.getUserById(Integer.parseInt(id));
         return ResponseEntity.ok(Optional.ofNullable(user)
                 .map(var -> new ApiResponse<>("success", "User fetched successfully", user))
                 .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id)));
    }

    @PutMapping("/update/user")
    private ResponseEntity<ApiResponse<User>> updateUser (@RequestBody User user) {
         return ResponseEntity.ok(Optional.ofNullable(userService.getUserById(user.getId())).map(var -> userService.updateUser(user))
                .map(var -> new ApiResponse<>("success", "User updated successfully", var))
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + user.getId())));
    }


    @DeleteMapping(value = "/delete/{id}")
    private ResponseEntity<ApiResponse<User>> deleteUserById(@PathVariable("id") String id) {
        return ResponseEntity.ok(Optional.ofNullable(userService.getUserById(Integer.parseInt(id)))
                .map(var -> new ApiResponse<>("success", "User deleted successfully", userService.deleteUserById(Integer.parseInt(id))))
                .orElseThrow(() -> new UserNotFoundException("User not found with id: "+ id)));
    }

}
