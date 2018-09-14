package com.cskaoyan.smzdm.controller;

import com.cskaoyan.smzdm.domain.Comment;
import com.cskaoyan.smzdm.domain.User;
import com.cskaoyan.smzdm.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 20:36 2018/9/14
 * @Modified By:
 */
@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/addComment")
    public String AddComment(String newsId, String content, HttpSession session, HttpServletRequest request){
        Comment comment = new Comment(content,new Date(),
                ((User)session.getAttribute("user")).getId(),Integer.valueOf(newsId));
        HashMap map = commentService.addComment(comment);
//        return "redirect:/news/"+newsId;
        return "/news/"+newsId;
    }

}
