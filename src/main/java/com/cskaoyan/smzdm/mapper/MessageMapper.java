package com.cskaoyan.smzdm.mapper;

import com.cskaoyan.smzdm.domain.Message;
import com.cskaoyan.smzdm.domain.VO.MessageVO;

import java.util.List;

public interface MessageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated Sun Sep 16 23:31:55 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated Sun Sep 16 23:31:55 CST 2018
     */
    int insert(Message record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated Sun Sep 16 23:31:55 CST 2018
     */
    int insertSelective(Message record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated Sun Sep 16 23:31:55 CST 2018
     */
    Message selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated Sun Sep 16 23:31:55 CST 2018
     */
    int updateByPrimaryKeySelective(Message record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated Sun Sep 16 23:31:55 CST 2018
     */
    int updateByPrimaryKey(Message record);

    List<MessageVO> selectVOsByConversationId(Integer conversationId);

    Message selectLastByConversationId(Integer conversationId);

    Integer selectCountByConversationId(Integer conversationId);

    Integer selectUnreadCountByConversationId(Integer conversationId);
}