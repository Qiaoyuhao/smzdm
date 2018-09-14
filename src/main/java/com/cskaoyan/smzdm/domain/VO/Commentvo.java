package com.cskaoyan.smzdm.domain.VO;

import com.cskaoyan.smzdm.domain.Comment;
import com.cskaoyan.smzdm.domain.News;
import com.cskaoyan.smzdm.domain.User;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:49 2018/9/14
 * @Modified By:
 */
public class Commentvo extends Comment {

    private User user;
    private News news;
    private Comment comment;


    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
