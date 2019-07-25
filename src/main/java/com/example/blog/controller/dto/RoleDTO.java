package com.example.blog.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class RoleDTO {

    private String name;

    public RoleDTO(String name) {
        this.name = name;
    }
}
