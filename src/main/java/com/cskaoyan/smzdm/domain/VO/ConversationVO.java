package com.cskaoyan.smzdm.domain.VO;

import com.cskaoyan.smzdm.domain.Conversation;
import com.cskaoyan.smzdm.domain.Message;
import com.cskaoyan.smzdm.domain.User;

/**
 * @Author: QiaoYuhao
 * @Description: 这里写代码的时候忘了getter setter方法导致，可以获取vo里的对象数据，但是前端无法显示，很低级的错误，导致的结果也很难查找和处理
 * @Date: Created in 18:53 2018/9/16
 * @Modified By:
 */
public class ConversationVO extends Conversation{

    private Conversation conversation;

    private User user;

    private Integer messageCount;

    private Integer unread;

    private Message lastMessage;


    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }

    @Override
    public Integer getUnread() {
        return unread;
    }

    @Override
    public void setUnread(Integer unread) {
        this.unread = unread;
    }

    public Message getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(Message lastMessage) {
        this.lastMessage = lastMessage;
    }
}
