package com.zt.book.dao.impl;

import com.zt.book.dao.UserDao;
import com.zt.book.pojo.Book;
import com.zt.book.pojo.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author tzz
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public User login(String userName, String userPassword) {
        String hql = "from User u where u.userName=:userName and u.userPassword=:userPassword";
        return sessionFactory.getCurrentSession().createQuery(hql, User.class).setParameter("userName", userName).setParameter("userPassword", userPassword).uniqueResult();
    }

    @Override
    public User findByName(String userName) {
        String hql = "from User u where u.userName=:userName";
        return sessionFactory.getCurrentSession().createQuery(hql, User.class).setParameter("userName", userName).uniqueResult();
    }
}
