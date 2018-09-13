package com.cskaoyan.smzdm.service.impl;

import com.cskaoyan.smzdm.domain.News;
import com.cskaoyan.smzdm.domain.User;
import com.cskaoyan.smzdm.domain.VO.VO;
import com.cskaoyan.smzdm.mapper.NewsMapper;
import com.cskaoyan.smzdm.mapper.UserMapper;
import com.cskaoyan.smzdm.service.VOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 16:26 2018/9/13
 * @Modified By:
 */

@Service
public class VOServiceImpl implements VOService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    NewsMapper newsMapper;

    public List<VO> findAllVO(){
        List<VO> vos = new LinkedList<VO>();
        List<News> newsList = newsMapper.selectAll();
        for (News news:newsList) {
            User user = userMapper.selectByPrimaryKey(news.getUid());
            VO vo = new VO();
            vo.setNews(news);
            vo.setUser(user);
            vos.add(vo);
        }
        return vos;
    }


}
