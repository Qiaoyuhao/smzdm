package com.cskaoyan.smzdm.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.cskaoyan.smzdm.domain.News;
import com.cskaoyan.smzdm.domain.User;
import com.cskaoyan.smzdm.domain.VO.VO;
import com.cskaoyan.smzdm.service.NewsService;
import com.cskaoyan.smzdm.service.UserService;
import com.cskaoyan.smzdm.service.VOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 9:37 2018/9/12
 * @Modified By:
 */

@Controller
public class InitController {

    @Autowired
    VOService voService;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String Init(Model model, HttpSession session, HttpServletRequest request){
        List<VO> vos = voService.findAllVO();
        model.addAttribute("vos",vos);
        Cookie[] cookies = request.getCookies();
        Cookie loginInfoCookie = null;
        if(cookies!=null){
            for (Cookie cookie :cookies) {
                if(cookie.getName().equals("loginInfo")){
                    loginInfoCookie = cookie;
                    break;
                }
            }
        }

        if(session.getAttribute("user")==null){
            if(loginInfoCookie!=null){
                String[] loginInfo = loginInfoCookie.getValue().split("/");
                String username = loginInfo[0];
                String password = loginInfo[1];

//                User jsonToUser = (User) JSONUtils.parse(loginInfoCookie.getValue());
                User user = userService.checkUsernameAndPassword(username, password);

//                User jsonToUser = JSONObject.parseObject(loginInfoCookie.getValue(), User.class);
//
//                User user = userService.checkUsernameAndPassword(jsonToUser.getUsername(), jsonToUser.getPassword());
                if(user!=null){
                    session.setAttribute("user",user);
                }
            }
        }
        return "home";
    }
}
