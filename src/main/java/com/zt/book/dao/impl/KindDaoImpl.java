package com.zt.book.dao.impl;

import com.zt.book.dao.KindDao;
import com.zt.book.pojo.Kind;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 */
@Repository
public class KindDaoImpl implements KindDao {

    @Resource
    private SessionFactory sessionFactory;


    @Override
    public List<Kind> findAll() {
        String hql = "from Kind k order by k.id";
        return sessionFactory.getCurrentSession().createQuery(hql, Kind.class).getResultList();
    }
}
