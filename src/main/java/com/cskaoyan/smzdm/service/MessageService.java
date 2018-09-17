package com.cskaoyan.smzdm.service;

import com.cskaoyan.smzdm.domain.Message;
import com.cskaoyan.smzdm.domain.VO.MessageVO;

import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 20:00 2018/9/16
 * @Modified By:
 */
public interface MessageService {

    boolean addMsg(String toName, Message message);

    List<MessageVO> getMsgByConversationId(String conversationId);
}
