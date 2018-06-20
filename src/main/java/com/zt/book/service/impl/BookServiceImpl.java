package com.zt.book.service.impl;

import com.zt.book.dao.BookDao;
import com.zt.book.dao.KindDao;
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

    @Resource
    private KindDao kindDao;

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Message addBook(Book book, String type) {
        Message msg = new Message();
        Book b = bookDao.findByName(book.getBookName());
        if (b == null) {
            String id = UUID.randomUUID().toString().substring(0, 4);
            book.setId(id);
            Kind kind = kindDao.findByType(type);
            if (kind == null) {
                kind = new Kind();
                String kid = UUID.randomUUID().toString().substring(0, 4);
                kind.setId(kid);
                kind.setType(type);
                kindDao.addKind(kind);
            }
            book.setKind(kind);
            bookDao.addBook(book);
            msg.setMsg("添加成功");
        } else {
            msg.setMsg("此书已存在");
        }
        return msg;
    }

    @Override
    public Message updateBook(Book book, String type) {
        Kind kind = kindDao.findByType(type);
        Book b = bookDao.findByBId(book.getId());
        if (b != null) {
            if (kind == null) {
                kind = new Kind();
                kind.setId(UUID.randomUUID().toString().substring(0, 4));
                kind.setType(type);
                kindDao.addKind(kind);
            }
            book.setKind(kind);
            bookDao.updateBook(book);
            return new Message("修改成功");
        } else {
            return new Message("图书不存在");
        }
    }

    @Override
    public List<Book> findByLike(String bookName) {
        return bookDao.findByLike(bookName);
    }

    @Override
    public Message deleteBook(String id) {
        Message msg = new Message();
        Book book = bookDao.findByBId(id);
        if (book == null) {
            msg.setMsg("已被删除或此书不存在");
        } else {
            bookDao.deleteBook(book);
            msg.setMsg("删除成功");
        }
        return msg;
    }
}
