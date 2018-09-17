package com.cskaoyan.smzdm.service.impl;

import com.cskaoyan.smzdm.domain.Conversation;
import com.cskaoyan.smzdm.domain.VO.ConversationVO;
import com.cskaoyan.smzdm.mapper.ConversationMapper;
import com.cskaoyan.smzdm.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 20:01 2018/9/16
 * @Modified By:
 */
@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    ConversationMapper conversationMapper;

    @Override
    public int getConversationId(Integer toId, Integer fromId) {
        Conversation conversation = new Conversation(toId,fromId);
        Integer conversationId = conversationMapper.getConversationId(conversation);
        if(null==conversationId){
            int insert = conversationMapper.insertSelective(conversation);
            if(insert==1){
                conversationId = conversationMapper.getConversationId(conversation);
            }
        }
        return conversationId;
    }

    @Override
    public List<ConversationVO> getAll() {
        List<ConversationVO> conversations = conversationMapper.selectAll();
        return conversations;
    }
}
