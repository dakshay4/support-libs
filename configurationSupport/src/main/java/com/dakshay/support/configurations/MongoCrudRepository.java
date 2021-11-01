package com.dakshay.support.configurations;

/**
 * Created by dakshay on 02/06/2021.
 */
public interface MongoCrudRepository<T> {

    public T save (T entity);
    public T findById(Long id);
}
