package com.zt.book.service.impl;

import com.zt.book.dao.BookDao;
import com.zt.book.pojo.Book;
import com.zt.book.pojo.Kind;
import com.zt.book.pojo.Message;
import com.zt.book.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author tzz
 * @Package com.zt.book.service.impl
 * @Name BookServiceImpl
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Message addBook(Book book) {
        Message msg = new Message();
        if (book.getBookName().equals("") || book.getBookName() == null || book.getKind() == null) {
            msg.setMsg("不可为空");
        } else {
            String id = UUID.randomUUID().toString().substring(0, 4);
            book.setId(id);
            Kind kind = new Kind();
            // kind.setType(book.);
            book.setKind(kind);
            bookDao.addBook(book);
            msg.setMsg("添加成功");
        }
        return msg;
    }
}
