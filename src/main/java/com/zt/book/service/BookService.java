package com.zt.book.service;

import com.zt.book.pojo.Book;
import com.zt.book.pojo.Message;

import java.util.List;

public interface BookService {

    List<Book> findAll();


    Message addBook(Book book, String type);

    Message updateBook(Book book);

    List<Book> findByLike(String bookName);
}
