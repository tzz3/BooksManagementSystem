package com.zt.book.controller;

import com.zt.book.pojo.User;
import com.zt.book.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author tzz
 */
@Controller
@RequestMapping("/users")
public class UserController {

    //注解 声明Service对象
    @Resource
    private UserService userService;


    @RequestMapping("/login")
    public ModelAndView login(User user, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        User u = userService.login(user);

        if (u != null) {//重定向 redirect:
            request.getSession().setAttribute("u", u);
            mav.setViewName("/index.jsp");
        } else {
            mav.addObject("msg", "用户名或者密码错误");
            mav.setViewName("/login.jsp");
        }
        return mav;
    }
}
