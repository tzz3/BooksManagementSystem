package com.zt.book.service;

import com.zt.book.pojo.Record;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReturnService {

    List<Record> findAll();
}
