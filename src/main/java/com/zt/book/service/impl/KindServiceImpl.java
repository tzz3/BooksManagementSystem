package com.zt.book.service.impl;

import com.zt.book.dao.KindDao;
import com.zt.book.pojo.Kind;
import com.zt.book.pojo.Message;
import com.zt.book.service.KindService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

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

    @Override
    public Message addKind(Kind kind) {
        String id = UUID.randomUUID().toString().substring(0, 4);
        kind.setId(id);
        Message msg = new Message();
        List<Kind> kinds = kindDao.findAll();
        try {
            if (!(kind.getType().equals("") || kind.getType() == null)) {
                if (kindDao.findByType(kind.getType()) != null) {
                    msg.setMsg("此分类已存在");
                    return msg;
                }
                kindDao.addKind(kind);
                msg.setMsg("添加成功");
            } else {
                msg.setMsg("必须输入类型名字");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg("系统异常");
        }
        return msg;
    }

    @Override
    public Message updateKind(Kind kind) {
        Message msg = new Message();
        try {
            Kind k = kindDao.findByType(kind.getType());
            kind.setId(k.getId());
            if (kindDao.updateKind(kind) == 1) {
                msg.setMsg("更新成功");
            } else {
                msg.setMsg("更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg("系统异常");
        }
        return msg;
    }
}
