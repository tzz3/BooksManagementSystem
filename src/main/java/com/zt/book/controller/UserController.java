package com.zt.book.controller;

import com.zt.book.pojo.Message;
import com.zt.book.pojo.User;
import com.zt.book.service.UserService;
import org.aspectj.bridge.MessageWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView();
        List<User> users = userService.findAll();
        mav.setViewName("/userList.jsp");
        mav.addObject("users", users);
        return mav;
    }

    @RequestMapping("/findByLike")
    public ModelAndView findByLike(String userName) {
        ModelAndView mav = new ModelAndView();
        List<User> users = userService.findByLike(userName);
        mav.setViewName("/userList.jsp");
        mav.addObject("users", users);
        return mav;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Message addUser(User user) {
        Message msg = new Message();
        try {
            return userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg("系统异常，添加失败");
            return msg;
        }
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public Message deleteUser(String id) {
        try {
            return userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("系统异常，删除失败");
        }
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public Message updateUser(User user) {
        try {
            return userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("系统异常，更新失败");
        }
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public Message updatePassword(String id, String pwd,String newpwd) {
        System.out.println(id + "\n" + pwd + "\n" + newpwd);
        try {
            return userService.updatePassword(id, pwd, newpwd);
        } catch (Exception e) {
            e.printStackTrace();
            return new Message("系统异常，密码修改失败");
        }
    }
}
