package ru.romankuznetsov.service;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface EntityDao<T> {
    public Optional<T> findByID(long id);
    public List<T> findAll();
    public void deleteByID(long id);
    void saveOrUpdate(T t);
}
