package com.zt.book.dao;

import com.zt.book.pojo.Book;
import com.zt.book.pojo.User;

public interface UserDao {

    User login(String userName, String userPassword);

    User findByName(String userName);
}
