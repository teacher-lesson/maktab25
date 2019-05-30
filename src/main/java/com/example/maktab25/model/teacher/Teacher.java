package com.example.maktab25.model.teacher;

import javax.persistence.*;

import static com.example.maktab25.model.teacher.Teacher.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
public class Teacher {

    // CONST
    public static final String TABLE_NAME = "teachers";
    public static final String ENTITY_NAME = "Teacher";

    //fields

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    // constructor


    // require
    public Teacher() {
        // require by hibernate(and jpa)
    }

    // optional
    public Teacher(String name) {
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
