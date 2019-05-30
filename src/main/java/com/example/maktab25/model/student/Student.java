package com.example.maktab25.model.student;

import javax.persistence.*;

import static com.example.maktab25.model.student.Student.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class Student {

    // CONST
    public static final String TABLE_NAME = "students";
    public static final String ENTITY_NAME = "Student";

    // fields

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    // constructor


    // require
    public Student() {
        // require by hibernate(and jpa)
    }

    // optional
    public Student(String name) {
        this.name = name;
    }

    // setter getter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
