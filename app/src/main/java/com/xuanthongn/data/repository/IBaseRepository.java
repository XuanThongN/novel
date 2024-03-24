package com.xuanthongn.data.repository;

import java.util.List;

public interface IBaseRepository<T> {
    T findById(int id);

    List<T> findAll();

    T insert(T t);

    T update(T t);

    void delete(T t);
}
