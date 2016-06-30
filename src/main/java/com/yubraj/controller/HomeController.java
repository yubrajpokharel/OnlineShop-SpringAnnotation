package com.yubraj.controller;

import com.yubraj.dao.UserDao;
import com.yubraj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by yubraj on 6/28/16.
 */

@Controller
public class HomeController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/")
    public String home(){
        User user = new User();
        user.setId(12345);
        user.setUsername("Yubraj");
        user.setPassword("asdfasdf");
        user.setEmail("asdfasdf");

        userDao.save(user);

        List<User> userList = userDao.findAll();
        return "home";
    }

}
