package com.zt.book.dao;

import com.zt.book.pojo.Book;
import com.zt.book.pojo.Kind;

import java.util.List;

public interface BookDao {
    List<Book> findAll();

    void addBook(Book book);

    List<Book> findById(String id);

    void updateBook(Book book);
}
