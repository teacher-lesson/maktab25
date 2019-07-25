package com.example.blog.service.impl;

import com.example.blog.core.service.BaseServiceImpl;
import com.example.blog.model.Post;
import com.example.blog.model.Role;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.RoleRepository;
import com.example.blog.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    protected RoleRepository getRepository() {
        return repository;
    }
}
