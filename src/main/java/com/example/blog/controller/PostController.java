package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Post> list(){
        return postService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Post post){
        postService.create(post);
        return ResponseEntity.status(402).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "/{id}")
    public Post getById(@PathVariable("id") Long id){
        return postService.getById(id);
    }


    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String addTest() {

        Post post = new Post();
        post.setContent("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Blanditiis eius facere impedit, minima nobis quae quas reiciendis rerum sint vel? Consequatur numquam perspiciatis quam quod repellat temporibus, ullam veritatis voluptatum?");
        post.setTitle("First post");
        post.setPublishDate(new Date());

        postService.create(post);

        return "ok";
    }
}
