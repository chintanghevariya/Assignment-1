package com.example.assignment1.services.interfaces;

import java.util.Set;

public interface CRUDinterface<T> {
    boolean create(T object);
    Set<T> getAll();
    T getById(Long id);
    boolean update(Long id, T object);
    boolean delete(Long id);

}
