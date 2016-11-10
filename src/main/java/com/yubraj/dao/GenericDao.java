package com.yubraj.dao;

import java.util.List;

/**
 * Created by yubraj on 6/29/16.
 */
public interface GenericDao<T> {

    void save(T t);
    void delete(Long id);
    T findOne(Long id);
    T update(T t);
    List<T> findAll();

}
