package com.zt.book.service.impl;

import com.zt.book.dao.UserDao;
import com.zt.book.pojo.User;
import com.zt.book.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author tzz
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public User login(User user) {
        return userDao.login(user.getUserName(),user.getUserPassword());
    }
}
