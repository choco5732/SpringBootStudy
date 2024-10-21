package com.basic.myspringboot.config.controller;

import com.basic.myspringboot.auth.UserInfo;
import com.basic.myspringboot.auth.UserInfoRepository;
import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.exception.BusinessException;
import com.basic.myspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // final로 선언된 변수에 대한 생성자를 자동으로 생겨줌
@RequestMapping("/api/users")
public class UserRestController {
    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;

    // @RequiredArgsConstructor 이 애노테이션이 아래 역할을 해줌
    // Constructor Injection
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }



    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public List<UserInfo> showAll() {
        return userInfoRepository.findAll();
    }

    @GetMapping("/{email}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public User getUser(@PathVariable String email) {
        return getUserByEmail(email);
    }

    // findById 리턴타입이 Optional이어서 orElseThrow()로 Exception 처리
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PatchMapping("/{email}")
    public User updateUser(@PathVariable String email, @RequestBody User userDetail) {
        User user = getUserByEmail(email);
        user.setName(userDetail.getName());
        return userRepository.save(user);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) {
        User user = getUserByEmail(email);
        userRepository.delete(user);
        return ResponseEntity.ok(email + " User Deleted Successfully");
    }

    private User getUserByEmail(String email) {
        return userRepository.findByEmail(email) // Optional<User>
                .orElseThrow(() -> new BusinessException(email + "User Not Found", HttpStatus.NOT_FOUND));
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome! this endpoint is not secure";
    }
}
