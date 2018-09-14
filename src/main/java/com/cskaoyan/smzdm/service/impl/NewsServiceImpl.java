package com.cskaoyan.smzdm.service.impl;

import com.cskaoyan.smzdm.domain.News;
import com.cskaoyan.smzdm.domain.VO.NewsVO;
import com.cskaoyan.smzdm.mapper.NewsMapper;
import com.cskaoyan.smzdm.service.NewsService;
import com.cskaoyan.smzdm.utils.JedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 14:58 2018/9/13
 * @Modified By:
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public HashMap addNews(News news) {
        int insert = newsMapper.insert(news);
        HashMap map = new HashMap();
        if(insert==1){
            map.put("code",0);
            map.put("msg","添加新闻成功");
        }else {
            map.put("code",1);
            map.put("msg","添加新闻失败");
        }

        return map;
    }

    @Override
    public List<News> findAllNews() {
        return newsMapper.selectAll();
    }

    @Override
    public NewsVO findNewsById(String id) {
        return newsMapper.selectByPrimaryKey(Integer.valueOf(id));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addLike(Integer nid, int uid) {
        Jedis jedis = JedisUtils.getJedis();
        jedis.sadd(nid+"like",Integer.toString(uid));
        jedis.srem(nid+"dislike",Integer.toString(uid));
        News news = newsMapper.selectNewsByPrimaryKey(nid);
        int likecount = Math.toIntExact(jedis.scard(nid + "like"));
        news.setLikeCount(likecount);
        newsMapper.updateByPrimaryKeySelective(news);
        return likecount;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addDislike(Integer nid, int uid) {
        Jedis jedis = JedisUtils.getJedis();
        jedis.srem(nid+"like",Integer.toString(uid));
        jedis.sadd(nid+"dislike",Integer.toString(uid));
        News news = newsMapper.selectNewsByPrimaryKey(nid);
        int likecount = Math.toIntExact(jedis.scard(nid + "like"));
        news.setLikeCount(likecount);
        newsMapper.updateByPrimaryKeySelective(news);
        return likecount;
    }
}
