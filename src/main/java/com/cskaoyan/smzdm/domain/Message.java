package com.cskaoyan.smzdm.domain;

import java.util.Date;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 23:07 2018/9/15
 * @Modified By:
 */

public class Message {

    private Integer id;

    private String content="赞了你的分享";

    private Integer conversationId;

    private Integer unread = 1;

    private Integer newsId;

    private Integer userId;

    private Date createdDate;

    public Message() {
    }

    public Message(String content, Integer userId, Date createdDate) {
        this.content = content;
        this.userId = userId;
        this.createdDate = createdDate;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public Integer getUnread() {
        return unread;
    }

    public void setUnread(Integer unread) {
        this.unread = unread;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
