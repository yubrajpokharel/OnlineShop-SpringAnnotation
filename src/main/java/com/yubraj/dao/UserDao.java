package com.yubraj.dao;

import com.yubraj.model.User;

/**
 * Created by yubraj on 6/29/16.
 */
public interface UserDao extends GenericDao<User> {
    public User findByEmail(String email);
}
