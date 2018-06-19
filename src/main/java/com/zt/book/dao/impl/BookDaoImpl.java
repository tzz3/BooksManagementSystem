package com.zt.book.dao.impl;

import com.zt.book.dao.BookDao;
import com.zt.book.pojo.Book;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 * @Package com.zt.book.dao.impl
 * @Name BookDaoImpl
 */
@Repository
public class BookDaoImpl implements BookDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List<Book> findAll() {
        String hql = "from Book book order by book.id";
        return sessionFactory.getCurrentSession().createQuery(hql, Book.class).getResultList();
    }

    @Override
    public void addBook(Book book) {
        sessionFactory.getCurrentSession().persist(book);
    }

    @Override
    public List<Book> findById(String id) {
        String hql = "from Book b where b.kind.id=:id";
        return sessionFactory.getCurrentSession().createQuery(hql, Book.class).setParameter("id", id).getResultList();
    }

    @Override
    public void updateBook(Book book) {
        sessionFactory.getCurrentSession().merge(book);
    }
}
