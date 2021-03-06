package com.zt.book.service.impl;

import com.zt.book.dao.ReturnDao;
import com.zt.book.pojo.Message;
import com.zt.book.pojo.Record;
import com.zt.book.service.ReturnService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ReturnServiceImpl implements ReturnService {

    @Resource
    private ReturnDao returnDao;

    @Override
    public List<Record> findAll() {
        return returnDao.findAll();
    }

    @Override
    public Message returnBook(String id) {
        Message msg = new Message();
        Record record = returnDao.findById(id);
        if (record != null) {
            returnDao.returnBook(record);
            msg.setMsg("还书完成");
        } else {
            msg.setMsg("此书已还");
        }
        return msg;
    }

    @Override
    public List<Record> findByLike(String userName) {
        return returnDao.findByLike(userName);
    }
}
