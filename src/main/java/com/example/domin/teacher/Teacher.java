package com.example.domin.teacher;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Teacher {

    @Id
    private Long id;
}
