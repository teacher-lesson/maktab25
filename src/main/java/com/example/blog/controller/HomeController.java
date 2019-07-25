package com.example.blog.controller;

import com.example.blog.model.User;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    public String home() {
        User user = new User();
        user.setName("Joe");
        user.setSureName("Doe");
        user.setUsername("admin");
        user.setPassword("admin");

        userService.create(user);
        return "OK";
    }

}
