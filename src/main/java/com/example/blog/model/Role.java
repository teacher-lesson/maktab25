package com.example.blog.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Data

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;

    @ManyToMany(mappedBy = "roles")
    protected Collection<User> users;

    @Override
    public String getAuthority() {
        return name;
    }
}
