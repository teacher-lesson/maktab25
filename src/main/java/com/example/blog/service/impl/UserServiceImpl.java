package com.example.blog.service.impl;

import com.example.blog.core.service.BaseServiceImpl;
import com.example.blog.model.User;
import com.example.blog.repository.UserRepository;
import com.example.blog.service.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected UserRepository getRepository() {
        return userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public User loadUserByUsername(String username) {
        User byUsername = userRepository.findByUsername(username);
        if (byUsername == null) {
            throw new UsernameNotFoundException("Username not found!");
        }
        return byUsername;
    }
}
