package com.nifelee.common.data;

import java.io.Serializable;
import java.util.List;

public interface GenericManager<T, K extends Serializable> {

  List<T> getAll();

  T get(K id);

  boolean exists(K id);

  T save(T entity);

  void delete(K id);

  void create(T entity);

  T merge(T entity);

  void update(T entity);

}

