package com.zt.book.service.impl;

import com.zt.book.dao.KindDao;
import com.zt.book.pojo.Kind;
import com.zt.book.service.KindService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 */
@Service
@Transactional
public class KindServiceImpl implements KindService {

    @Resource
    private KindDao kindDao;

    @Override
    public List<Kind> findAll() {
        return kindDao.findAll();
    }
}
