package com.cskaoyan.smzdm.service.impl;

import com.cskaoyan.smzdm.domain.Message;
import com.cskaoyan.smzdm.domain.VO.MessageVO;
import com.cskaoyan.smzdm.mapper.ConversationMapper;
import com.cskaoyan.smzdm.mapper.MessageMapper;
import com.cskaoyan.smzdm.mapper.UserMapper;
import com.cskaoyan.smzdm.service.ConversationService;
import com.cskaoyan.smzdm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 20:00 2018/9/16
 * @Modified By:
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;
    @Autowired
    ConversationMapper conversationMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ConversationService conversationService;

    @Override
    public boolean addMsg(String toName, Message message) {

        Integer idByUsername = userMapper.getIdByUsername(toName);
        int toId = idByUsername;
        int fromId = message.getUserId();
//        int conversationId = conversationService.getConversationId(idByUsername,message.getUserId());
        int conversationId = conversationService.getConversationId(toId,fromId);
        message.setConversationId(conversationId);

        int insert = messageMapper.insert(message);

        return insert==1;
    }

    @Override
    public List<MessageVO> getMsgByConversationId(String conversationId) {
        List<MessageVO> messages = messageMapper.selectVOsByConversationId(Integer.valueOf(conversationId));
        return messages;
    }
}
