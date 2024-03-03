package com.example.docker.controller;

import com.example.docker.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloController {

    private final UserRepository userRepository;

    public HelloController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("hello")
    public String getHello() {
        return "hello!!";
    }

    @GetMapping("count")
    public Integer getCount(Long userId){
        Integer count = userRepository.findCount(userId);
        if (Objects.isNull(count)) {
            userRepository.save(userId, 1);
            return 1;
        }
        count += 1;
        userRepository.save(userId, count);
        return count;
    }
}
