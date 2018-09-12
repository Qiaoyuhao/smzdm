package com.cskaoyan.smzdm.domain.VO;

import com.cskaoyan.smzdm.domain.News;
import com.cskaoyan.smzdm.domain.User;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 13:11 2018/9/12
 * @Modified By:
 */
public class VO {

    private User user;
    private News news;
    private int like;

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
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
