package com.example.dbtermprojectspringboot.controller;

import com.example.dbtermprojectspringboot.domain.User;
import com.example.dbtermprojectspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    public UserRepository userRepository;

    @PostMapping("/save")
    public int data(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @PostMapping("/delete")
    public int delete(@RequestParam("userID") String userId) {
        return this.userRepository.delete(userId);
    }

    @PostMapping("/getUser")
    public User getUserById(@RequestParam("userID") String userId){
        return this.userRepository.getUserObjById(userId);
    }
}
