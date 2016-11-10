package com.yubraj.dao.impl;

import com.yubraj.dao.UserDao;
import com.yubraj.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yubraj on 6/29/16.
 */
@Repository
@Transactional
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao{

    public UserDaoImpl() {
        super.setDaoType(User.class);
    }

    public User findByEmail(String email) {

        return (User) sessionFactory.getCurrentSession().createQuery("select u from "+daoType.getName()+" u where u.email= "+email).list().get(0);
    }
}
