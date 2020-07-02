package com.brilife.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

public interface CommonService<T, ID> {
    T save(T entity);

    T removeById(ID id);

    T findById(ID id);

    Page<T> findAllByExample(T entity, int page, int size, Direction direction);
}