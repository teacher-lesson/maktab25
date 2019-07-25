package com.example.blog.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Lob
    protected String content;

    protected String title;

    @CreationTimestamp
    @Column(updatable = false)
    protected Date createDate;

    protected Date publishDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    protected User writer;
}
