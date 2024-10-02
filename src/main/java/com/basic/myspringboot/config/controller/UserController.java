package com.basic.myspringboot.config.controller;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.exception.BusinessException;
import com.basic.myspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor // final로 선언된 변수에 대한 생성자를 자동으로 생겨줌
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;

    // @RequiredArgsConstructor 이 애노테이션이 아래 역할을 해줌
    // Constructor Injection
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BusinessException("User Not Found", HttpStatus.NOT_FOUND));
    }

    // findById 리턴타입이 Optional이어서 orElseThrow()로 Exception 처리


}
