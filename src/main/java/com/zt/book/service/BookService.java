package com.zt.book.service;

import com.zt.book.pojo.Book;
import com.zt.book.pojo.Message;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Message addBook(Book book, String type);

    Message updateBook(Book book, String type);

    List<Book> findByLike(String bookName);

    Message deleteBook(String id);
}
