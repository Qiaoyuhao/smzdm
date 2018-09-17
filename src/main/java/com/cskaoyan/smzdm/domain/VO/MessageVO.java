package com.cskaoyan.smzdm.domain.VO;

import com.cskaoyan.smzdm.domain.Message;
import com.cskaoyan.smzdm.domain.User;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 22:03 2018/9/16
 * @Modified By:
 */
public class MessageVO extends Message {

    private User user;
    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
