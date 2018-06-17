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
    public Kind findByType(String type) {
        String hql = "from Kind k where k.type=:type";
        return sessionFactory.getCurrentSession().createQuery(hql, Kind.class).setParameter("type", type).uniqueResult();
    }

    @Override
    public List<Kind> findAll() {
        String hql = "from Kind k order by k.id";
        return sessionFactory.getCurrentSession().createQuery(hql, Kind.class).getResultList();
    }

    @Override
    public void addKind(Kind kind) {
        sessionFactory.getCurrentSession().persist(kind);
    }

    @Override
    public void updateKind(Kind kind) {
        String hql = "update Kind k set k.type=:type where k.id=:id";
        sessionFactory.getCurrentSession().createQuery(hql).setParameter("type", kind.getType()).setParameter("id", kind.getId()).executeUpdate();
    }
}
