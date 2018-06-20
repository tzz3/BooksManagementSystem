package com.zt.book.controller;

import com.zt.book.pojo.Book;
import com.zt.book.pojo.Message;
import com.zt.book.service.BookService;
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


    @RequestMapping("/findByLike")
    public ModelAndView findByLike(String bookName) {
        ModelAndView mav = new ModelAndView();
        List<Book> books = bookService.findByLike(bookName);
        mav.setViewName("/book.jsp");
        mav.addObject("books", books);
        return mav;
    }

    @RequestMapping("/addBook")
    @ResponseBody
    public Message addBook(Book book, String type) {
        try {
            return bookService.addBook(book, type);
        } catch (Exception e) {
            e.printStackTrace();
            Message msg = new Message();
            msg.setMsg("系统异常");
            return msg;
        }
    }

    @RequestMapping("/updateBook")
    @ResponseBody
    public Message updateBook(Book book, String type) {
        try {
            return bookService.updateBook(book, type);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("更新失败");
        }
    }

    @RequestMapping("/deleteBook")
    @ResponseBody
    public Message deleteBook(String id) {
        try {
            return bookService.deleteBook(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("系统异常");
        }
    }
}
