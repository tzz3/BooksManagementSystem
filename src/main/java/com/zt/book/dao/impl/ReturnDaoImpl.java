package com.zt.book.dao.impl;

import com.zt.book.dao.ReturnDao;
import com.zt.book.pojo.Record;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 * @Package com.zt.book.dao.impl
 * @Name ReturnDaoImpl
 */
@Repository
public class ReturnDaoImpl implements ReturnDao {
    @Resource
    private SessionFactory sessionFactory;


    @Override
    public List<Record> findAll() {
        String hql = "from Record r order by r.id";
        return sessionFactory.getCurrentSession().createQuery(hql, Record.class).getResultList();
    }
}
