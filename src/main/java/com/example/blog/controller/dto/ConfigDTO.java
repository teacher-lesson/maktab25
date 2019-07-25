package com.example.blog.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Setter
@Getter
@NoArgsConstructor


public class ConfigDTO {

    private String fullName;

    private String username;

    private Collection<RoleDTO> roles;

    public ConfigDTO(String fullName, String username) {
        this.fullName = fullName;
        this.username = username;
    }
}
