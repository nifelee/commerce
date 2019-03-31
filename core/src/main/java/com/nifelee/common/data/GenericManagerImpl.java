package com.nifelee.common.data;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Transactional(readOnly = true)
public class GenericManagerImpl<T, K extends Serializable> implements GenericManager<T, K> {

  protected JpaRepository<T, K> repository;

  @PersistenceContext
  protected EntityManager entityManager;

  public GenericManagerImpl() {
  }

  public GenericManagerImpl(JpaRepository<T, K> genericRepository) {
    this.repository = genericRepository;
  }

  @Override
  public List<T> getAll() {
    return repository.findAll();
  }

  @Override
  public T get(K id) {
    return repository.findById(id)
            .orElse(null);
  }

  @Override
  public boolean exists(K id) {
    return repository.existsById(id);
  }

  @Override
  @Transactional
  public T save(T entity) {
    return repository.save(entity);
  }

  @Override
  @Transactional
  public void delete(K id) {
    repository.deleteById(id);
  }

  @Override
  @Transactional
  public void create(T entity) {
    entityManager.persist(entity);
  }

  @Override
  @Transactional
  public T merge(T entity) {
    return entityManager.merge(entity);
  }

  @Override
  @Transactional
  public void update(T entity) {
    entityManager.unwrap(Session.class).update(entity);
  }

}

