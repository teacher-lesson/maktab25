package com.example.domin.teacher;

import lombok.*;

import javax.persistence.*;

@Data

@Entity
@Table
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    private String name;

    private String sureName;

}
