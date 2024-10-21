package com.basic.myspringboot.config.controller;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// html이라 restconroller말고 controller 사용
@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping("/thymeleaf")
    public String leaf(Model model) {
        model.addAttribute("name", "test");
        return "leaf"; // 템플릿 엔진인 Thymeleaf가 leaf.html이라는 이름의 템플릿을 찾아 렌더링하도록 지정합니다.
    }

//    @PostMapping("/insert")
//    public String insert() {
//        userRepository.save(new User("test", "test"));
//    }
}
