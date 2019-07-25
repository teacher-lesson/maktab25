package com.example.blog.controller;

import com.example.blog.model.Role;
import com.example.blog.model.User;
import com.example.blog.service.UserService;
import com.example.blog.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Value("${datasource.username}")
    private String datasourceUsername;

    @RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User home() {
        User user = new User();
        user.setName("Joe");
        user.setSureName("Doe");
        user.setUsername("admin");
        user.setPassword("admin");
        user.setActive(true);

        Role admin = new Role("ROLE_ADMIN");
        Role sysadmin = new Role("ROLE_SYSADMIN");
        Role userRole = new Role("ROLE_USER");

        roleService.create(admin);
        roleService.create(sysadmin);
        roleService.create(userRole);

        Set<Role> roles = new HashSet<>();
        roles.add(admin);
        roles.add(sysadmin);
        roles.add(userRole);

        user.setRoles(roles);

        userService.create(user);
        return user;
    }

    @GetMapping(value = "/db")
    public String db() {
        return datasourceUsername;
    }

}
