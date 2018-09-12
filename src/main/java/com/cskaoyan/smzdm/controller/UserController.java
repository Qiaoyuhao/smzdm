package com.cskaoyan.smzdm.controller;

import com.cskaoyan.smzdm.domain.User;
import com.cskaoyan.smzdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 9:51 2018/9/12
 * @Modified By:
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/reg")
    @ResponseBody
    public HashMap reg(String username,String password){
        User user  = new User(username,password);
        HashMap map = userService.addUser(user);
        return map;
    }

    @RequestMapping("/login")
    @ResponseBody
    public HashMap login(String username, String password, HttpSession session){
        User user = new User(username,password);
        HashMap map = userService.login(user);
        if((Integer) map.get("code") ==0){
            User userByFind = (User) map.get("user");
            session.setAttribute("user",userByFind);
        }
        return map;
    }

    @RequestMapping("/user/{id}")
    public String find(@PathVariable String id){
        return "personal";

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "home";

    }
}
