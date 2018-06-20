package com.zt.book.controller;

import com.zt.book.pojo.Record;
import com.zt.book.service.ReturnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 * @Package com.zt.book.controller
 * @Name returnController
 */
@RequestMapping("/returns")
@Controller
public class ReturnController {

    @Resource
    private ReturnService returnSerivice;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView();
        List<Record> records = returnSerivice.findAll();
        mav.addObject("records", records);
        mav.setViewName("/return.jsp");
        return mav;
    }
}
