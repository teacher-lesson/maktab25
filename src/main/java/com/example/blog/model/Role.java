package com.example.blog.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;

    @ManyToMany(mappedBy = "roles")
    protected Collection<User> users;

}
