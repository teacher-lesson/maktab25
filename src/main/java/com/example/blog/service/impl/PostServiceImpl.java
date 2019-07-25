package com.example.blog.service.impl;

import com.example.blog.core.service.BaseServiceImpl;
import com.example.blog.model.Post;
import com.example.blog.repository.PostRepository;
import com.example.blog.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostServiceImpl extends BaseServiceImpl<Post> implements PostService {

    private final PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    protected PostRepository getRepository() {
        return repository;
    }
}
