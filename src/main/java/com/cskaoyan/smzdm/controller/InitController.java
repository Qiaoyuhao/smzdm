package com.cskaoyan.smzdm.controller;

import com.cskaoyan.smzdm.domain.News;
import com.cskaoyan.smzdm.domain.User;
import com.cskaoyan.smzdm.domain.VO.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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

    @RequestMapping("/")
    public String Init(Model model, HttpSession session){
        News news = new News(1,"1","1","test","1",new Date());
        List<VO> vos = new LinkedList<>();
        VO vo = new VO();
        vo.setNews(news);
        vos.add(vo);
        model.addAttribute("vos",vos);
        return "home";
    }
}
