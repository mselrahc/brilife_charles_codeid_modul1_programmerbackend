package com.brilife.backend.services.impl;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import com.brilife.backend.services.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public abstract class CommonServiceImpl<T, ID, R extends JpaRepository<T, ID>>
  implements CommonService<T, ID> {
  @Autowired
  private R repository;

  protected R getRepository() {
    return this.repository;
  }

  public T save(T entity) {
    return repository.save(entity);
  }

  public T removeById(ID id) {
    T entity = findById(id);
    repository.delete(entity);
    return entity;
  }

  public T findById(ID id) {
    return repository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public Page<T> findAllByExample(
    T entity,
    int page,
    int size,
    Direction direction
  ) {
    ExampleMatcher matcher = ExampleMatcher
      .matchingAny()
      .withIgnoreCase()
      .withStringMatcher(StringMatcher.CONTAINING);
    return findAll(entity, page, size, direction, matcher);
  }

  public Page<T> findAll(
    T entity,
    int page,
    int size,
    Direction direction,
    ExampleMatcher matcher
  ) {
    Sort sort = Sort.by(direction, "id");
    return repository.findAll(
      Example.of(entity, matcher),
      PageRequest.of(page, size, sort)
    );
  }
}
