package com.example.blog.core.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseServiceImpl<E> implements BaseService<E> {

    protected abstract JpaRepository<E, Long> getRepository();

    @Override
    public void create(E e) {
        getRepository().save(e);
    }

    @Override
    public void update(E e) {
        getRepository().save(e);
    }

    @Override
    public E getById(Long id) {
        return getRepository().findById(id).get();
    }

    @Override
    public void delete(E e) {
        getRepository().delete(e);
    }

    @Override
    public void deleteById(Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public List<E> getAll() {
        return getRepository().findAll();
    }
}
