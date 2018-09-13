package com.cskaoyan.smzdm.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.cskaoyan.smzdm.domain.News;
import com.cskaoyan.smzdm.domain.User;
import com.cskaoyan.smzdm.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 14:57 2018/9/13
 * @Modified By:
 */

@Controller
public class NewsController {

    @Autowired
    NewsService newsService;

    @RequestMapping("/user/addNews")
    @ResponseBody
    public String addNews(News news, HttpSession session){
        User user = (User) session.getAttribute("user");
        news.setUid(user.getId());
        news.setCreatedDate(new Date());
        HashMap map = newsService.addNews(news);
        String toJSONString = JSONUtils.toJSONString(map);
        return toJSONString;
    }

}
