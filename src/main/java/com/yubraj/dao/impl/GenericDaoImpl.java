package com.yubraj.dao.impl;

import com.yubraj.dao.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yubraj on 6/29/16.
 */

@Transactional
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    @Autowired
    SessionFactory sessionFactory;

    protected Class<T> daoType;

    public void setDaoType(Class<T> dao){
        daoType = dao;
    }

    public void save(T t) {
        sessionFactory.getCurrentSession().save(t);
    }

    public void delete(Long id) {
        T entity = findOne(id);
        delete(entity);
    }

    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }

    public T findOne(Long id) {
        return (T) sessionFactory.getCurrentSession().get(daoType, id);
    }

    public T update(T t) {
        return (T) sessionFactory.getCurrentSession().merge(t);
    }

    public List<T> findAll() {
//        return sessionFactory.getCurrentSession()
//                .createQuery("select u from " + daoType.getClass().getName()+" u").list();
        List<T> listUser = (List<T>) sessionFactory.getCurrentSession()
                .createCriteria(daoType)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return listUser;
    }


}
