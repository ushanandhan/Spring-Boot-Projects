package com.example.user.controller;

import com.example.user.dto.UserResponse;
import com.example.user.entity.User;
import com.example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of User Controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserResponse findUserById(@PathVariable("id") Long userId){
        log.info("Inside findUserById of User Controller");
        return userService.findUserById(userId);
    }
}
