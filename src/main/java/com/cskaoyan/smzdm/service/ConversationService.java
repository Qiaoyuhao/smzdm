package com.cskaoyan.smzdm.service;

import com.cskaoyan.smzdm.domain.VO.ConversationVO;

import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 20:01 2018/9/16
 * @Modified By:
 */
public interface ConversationService {

    int getConversationId(Integer toId, Integer fromId);

    List<ConversationVO> getAll();
}
