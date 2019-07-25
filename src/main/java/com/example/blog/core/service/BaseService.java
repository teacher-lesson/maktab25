package com.example.blog.core.service;

import java.util.List;

public interface BaseService<E> {

    void create(E e);

    void update(E e);

    E getById(Long id);

    void delete(E e);

    void deleteById(Long id);

    List<E> getAll();
}
