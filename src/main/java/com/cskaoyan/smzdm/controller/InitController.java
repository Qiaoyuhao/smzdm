package com.cskaoyan.smzdm.controller;

import com.cskaoyan.smzdm.domain.News;
import com.cskaoyan.smzdm.domain.User;
import com.cskaoyan.smzdm.domain.VO.VO;
import com.cskaoyan.smzdm.service.NewsService;
import com.cskaoyan.smzdm.service.UserService;
import com.cskaoyan.smzdm.service.VOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 9:37 2018/9/12
 * @Modified By:
 */

@Controller
public class InitController {

    @Autowired
    VOService voService;

    @RequestMapping("/")
    public String Init(Model model){
        List<VO> vos = voService.findAllVO();
        model.addAttribute("vos",vos);
        return "home";
    }
}
