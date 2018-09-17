package com.cskaoyan.smzdm.controller;

import com.cskaoyan.smzdm.domain.Message;
import com.cskaoyan.smzdm.domain.User;
import com.cskaoyan.smzdm.domain.VO.ConversationVO;
import com.cskaoyan.smzdm.domain.VO.MessageVO;
import com.cskaoyan.smzdm.service.ConversationService;
import com.cskaoyan.smzdm.service.MessageService;
import com.cskaoyan.smzdm.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 19:59 2018/9/16
 * @Modified By:
 */
@Controller
public class MessageController {

    @Autowired
    MessageService messageService;
    @Autowired
    ConversationService conversationService;


    @RequestMapping("/msg/list")
    public String getMsgList(Model model){
        //查询msg(事实上是查询conversationVO)并返回到letter页面
        List<ConversationVO> conversations = conversationService.getAll();
        model.addAttribute("conversations",conversations);
        return "letter";
    }

    @RequestMapping("/user/tosendmsg")
    public String toSendMsg(){
        return "sendmsg";
    }

    @RequestMapping("/user/msg/addMessage")
    @ResponseBody
    public HashMap addMsg(String toName, String content, HttpSession session){

        //添加成功后会自动跳转到msg/list(前端的动作)，这里需要添加操作，以及返回添加结果的map
        HashMap map = null;
        Object userObject = session.getAttribute("user");

        if(null==userObject){
            map = ResultUtils.resultMsg(1,"未登录，请登录重试");
        }else {
            User user = (User) userObject;
            Message message = new Message(content, user.getId(), new Date());
            boolean addRet = messageService.addMsg(toName, message);
            if(addRet){
                map = ResultUtils.resultMsg(0,"");
            }else {
                map = ResultUtils.resultMsg(1,"添加失败，请重试");
            }
        }

        return map;
    }
//    @RequestParam("file")
    @RequestMapping("/msg/detail")
    public String getMsgDetail(@RequestParam("conversationId") String conversationId, Model model){
        //根据conversationId查询messageVO并返回数据到detail页面
        List<MessageVO> messages = messageService.getMsgByConversationId(conversationId);
        model.addAttribute("messages",messages);
        return "letterDetail";
    }
}
