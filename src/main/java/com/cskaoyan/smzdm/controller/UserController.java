package com.cskaoyan.smzdm.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.cskaoyan.smzdm.domain.User;
import com.cskaoyan.smzdm.service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    /**
     * @Author: QiaoYuhao
     * @Description: 注册页面
     * @param:  username
     * @param:  password
     * @return:  返回注册结果信息
     */
    @RequestMapping("/reg")
    @ResponseBody
    public HashMap reg(String username,String password){
        User user  = new User(username,password);
        HashMap map = userService.addUser(user);
        return map;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: 登录页面
     *               如果选择了记住登录，则将user的信息存入cookie，刷新主页的时候会查看cookie中是否有user的信息，并验证和自动登录
     *
     * @param:  username
     * @param:  password
     * @param:  session
     * @return:  返回登录结果信息
     */
    @RequestMapping("/login")
    @ResponseBody
    @JsonIgnore
    public HashMap login(String username, String password, HttpSession session, HttpServletRequest request,
                         HttpServletResponse response,@RequestParam("rember") int rember){
        User user = new User(username,password);
        HashMap map = userService.login(user);
        if((Integer) map.get("code") ==0){
            User userByFind = (User) map.get("user");
            session.setAttribute("user",userByFind);
            //如果记住登录，则将用户信息存入cookie
            if(rember>0){
                Cookie cookie = new Cookie("loginInfo",
                        userByFind.getUsername()+"/"+userByFind.getPassword());

//                String userToJson = JSONUtils.toJSONString(userByFind);
//                String userToJson = JSONObject.toJSONString(userByFind, true);

//                Object toJSON = JSONObject.toJSON(userByFind);

//                Cookie cookie = new Cookie("loginInfo",userToJson);
                cookie.setMaxAge(3600*24*7);

                //setPath,cookie跨路径有效
                cookie.setPath("/");
                response.addCookie(cookie);

            }
        }
        return map;
    }

    /**
     * @Author: QiaoYuhao
     * @Description: 返回个人信息查询页面，这里有一个取巧的地方
     *               有两个地方会用到这个url，一个是已登陆用户查询个人信息，另一个是查询news对象的发布者的个人信息
     *               已登录用户的个人信息查询是不需要对数据库进行查询的，因为session中存放有user的信息
     *               如果这里返回user，则会与已登录用户的session里存在的user对象冲突，导致无法正确显示
     *               于是在前端personal的页面，加了#if (${owner}),来判断是否有owner对象返回，没有的话正常显示session中的user信息
     *               如果有owner对象的话，显示news发布者owner的信息
     *               而在controller里，默认根据id查询user信息，并以“owner”为key值存放在model里
     *
     *               这里并不一定需要命名为owner,命名为任何除了user以外的名字均可
     * @param:  id
     * @param:  model
     * @return:  返回到personal页面
     */
    @RequestMapping("/user/{id}")
    public String find(@PathVariable String id, Model model){
        HashMap byId = userService.findById(id);
        User user = (User) byId.get("user");
        model.addAttribute("owner",user);
        return "personal";
    }

    /**
     * @Author: QiaoYuhao
     * @Description: 登出分为两部分，一部分是session的清除，另一部分是使记住登录的cookie的失效
     * @param:
     * @param:
     * @return:
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request,HttpServletResponse response){
        session.invalidate();
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie:cookies) {
                if(cookie.getName().equals("loginInfo")){
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    break;
                }

            }
        }
        return "redirect:/";

    }
}
