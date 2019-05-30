package com.example.maktab25.model;

import com.example.maktab25.model.student.Student;
import com.example.maktab25.model.teacher.Teacher;

import java.util.List;
import java.util.Set;

public class User {

    private Long id;

    private String username;

    private String password;

    private String name;

    private Set<Student> students;

    private List<Teacher> teachers;

}
