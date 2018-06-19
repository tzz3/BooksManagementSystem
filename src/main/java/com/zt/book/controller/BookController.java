package com.zt.book.controller;

import com.zt.book.pojo.Book;
import com.zt.book.pojo.Message;
import com.zt.book.service.BookService;
import net.sf.json.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tzz
 * @Package com.zt.book.controller
 * @Name BookController
 */
@Controller
@RequestMapping("/books")
public class BookController {
    @Resource
    private BookService bookService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView();
        List<Book> books = bookService.findAll();
        mav.addObject("books", books);
        mav.setViewName("/book.jsp");
        return mav;
    }

    @RequestMapping("/addBook")
    @ResponseBody
    public Message addBook(Book book,String type) {
        System.out.println(book.toString());
        System.out.println(type);
        // try {
        //     return bookService.addBook(book);
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     Message msg = new Message();
        //     msg.setMsg("系统异常");
        //     return msg;
        // }
        return null;
    }
}
