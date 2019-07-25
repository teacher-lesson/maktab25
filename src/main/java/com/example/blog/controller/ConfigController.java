package com.example.blog.controller;

import com.example.blog.controller.dto.ConfigDTO;
import com.example.blog.controller.dto.RoleDTO;
import com.example.blog.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class ConfigController {


    @RequestMapping("/config")
    public ConfigDTO whoami() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal == null || principal instanceof String) {
            return new ConfigDTO("guest","guest");
        }

        User user = (User) principal;
        ConfigDTO configDTO =
                new ConfigDTO(user.getName() + " " + user.getSureName(), user.getUsername());

        configDTO.setRoles(user.getRoles().stream().map(r -> new RoleDTO(r.getName())).collect(Collectors.toSet()));

        return configDTO;
    }
}
