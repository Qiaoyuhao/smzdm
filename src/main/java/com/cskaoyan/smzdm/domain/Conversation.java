package com.cskaoyan.smzdm.domain;

import java.util.Date;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 18:52 2018/9/16
 * @Modified By:
 */
public class Conversation {

    private Integer conversationId;

    private Integer fromId;

    private Integer toId;

    private Integer unread = 1;

    private Date createdDate;

    private Date readDate;

    public Conversation() {
    }

    public Conversation(Integer fromId, Integer toId) {
        this.fromId = fromId;
        this.toId = toId;
    }

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public Integer getUnread() {
        return unread;
    }

    public void setUnread(Integer unread) {
        this.unread = unread;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }
}
