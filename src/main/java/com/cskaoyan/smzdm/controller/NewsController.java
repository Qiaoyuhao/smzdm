package com.cskaoyan.smzdm.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.cskaoyan.smzdm.domain.News;
import com.cskaoyan.smzdm.domain.User;
import com.cskaoyan.smzdm.domain.VO.Commentvo;
import com.cskaoyan.smzdm.domain.VO.NewsVO;
import com.cskaoyan.smzdm.domain.VO.Owner;
import com.cskaoyan.smzdm.service.CommentService;
import com.cskaoyan.smzdm.service.NewsService;
import com.cskaoyan.smzdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;

    /**
     * @Author: QiaoYuhao
     * @Description: 添加新的news条目
     * @param:  news新的news对象
     * @param:  session获取当前登录对象user的信息，因为当前添加news的用户必然是已登录用户
     * @return: 返回添加结果
     */
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

    /**
     * @Author: QiaoYuhao
     * @Description: 根据news的id获取当前news条目的详情,owner是为了和session里的user对象相区分
     * @param:  id
     * @param:  model
     * @return: 返回到detail页面
     */
    @RequestMapping("/news/{id}")
    public String findNewsById(@PathVariable String id, Model model){
        NewsVO news = newsService.findNewsById(id);
        HashMap byId = userService.findById(String.valueOf(news.getUid()));
        User owner = (User) byId.get("user");
        List<Commentvo> comments = commentService.findAllCommentByNid(Integer.valueOf(id));
        model.addAttribute("news",news);
        model.addAttribute("owner",owner);
        model.addAttribute("comments",comments);
        return "detail";
    }

    @RequestMapping("/like")
    @ResponseBody
    public HashMap addLike(String newsId,HttpSession session){
       User user = (User) session.getAttribute("user");
        int like = newsService.addLike(Integer.valueOf(newsId), user.getId());
        HashMap map = new HashMap();
        map.put("msg",like);
        map.put("code",0);
        return map;
    }

    @RequestMapping("/dislike")
    @ResponseBody
    public HashMap addDislike(String newsId,HttpSession session){
        User user = (User) session.getAttribute("user");
        int like = newsService.addDislike(Integer.valueOf(newsId), user.getId());
        HashMap map = new HashMap();
        map.put("msg",like);
        map.put("code",0);
        return map;
    }

}
