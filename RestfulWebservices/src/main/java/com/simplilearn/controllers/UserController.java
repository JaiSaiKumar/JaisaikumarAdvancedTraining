package com.simplilearn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.entity.User;
import com.simplilearn.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public boolean findByEmail(@RequestBody User user) {
        User obj = userService.getUserByEmail(user.getEmail());
        return obj != null && user.getEmail().equals(obj.getEmail()) && user.getPassword().equals(obj.getPassword());
    }

    @GetMapping("/list")
    public List<User> UserDetails() {
        return userService.listAll();

    }

    @PostMapping("/update")
    public User updateById(@RequestBody User user) {
        User dbUser = userService.FindByid(user.getId());
        if (dbUser != null) {
            dbUser.setEmail(user.getEmail());
            dbUser.setName(user.getName());
            dbUser.setPhone(user.getPhone());
            dbUser.setPassword(user.getPassword());
            return userService.save(user);
        }
        return user;
    }

    @PostMapping("/register")
    public User Register(@RequestBody User user) {
        userService.save(user);
        return user;
    }

}
