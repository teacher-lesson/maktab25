package com.example.blog.model;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String username;

    protected String password;

    protected String name;

    @Column(name = "sure_name")
    protected String sureName;

    @Column(name = "is_active")
    protected boolean active;
}
