package com.basic.myspringboot.config.controller;

import com.basic.myspringboot.repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;

    // Constructor Injection
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
