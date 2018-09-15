package com.cskaoyan.smzdm.service.impl;

import com.cskaoyan.smzdm.domain.News;
import com.cskaoyan.smzdm.domain.VO.NewsVO;
import com.cskaoyan.smzdm.mapper.NewsMapper;
import com.cskaoyan.smzdm.service.NewsService;
import com.cskaoyan.smzdm.utils.JedisUtils;
import com.cskaoyan.smzdm.utils.ResultUtils;
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

//    int countForLike = 0;
//    int countForDislike = 0;

    @Override
    public HashMap addNews(News news) {
        int insert = newsMapper.insert(news);
        HashMap map = null;
        if(insert==1){
            map = ResultUtils.resultMsg(0, "添加新闻成功");
        }else {
            map = ResultUtils.resultMsg(1, "添加新闻失败");
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

    /**
     * @Author: QiaoYuhao
     * @Description: 点赞点踩功能问题：实现1：相当于只实现点赞和取消点赞
     * 实现2：分别实现点赞和点踩，但如果点踩数大于点赞数，页面赞数依然会是0，这时点赞点赞数不会增加，逻辑上没有错误，但是直观给用户的感觉是点赞没有生效
     *       实现点第二次赞为取消点赞，点踩也为同样
     * @param:
     * @param:
     * @return:
     */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addLike(Integer nid, int uid) {

        int likecount = 0;
        Jedis jedis = null;
        try {
            jedis = JedisUtils.getJedis();

        jedis.sadd(nid+"like",Integer.toString(uid));
        likecount = Math.toIntExact(jedis.scard(nid + "like"));

//            if(countForLike%2==0){
//                jedis.sadd(nid + "like", Integer.toString(uid));
//                countForLike++;
//            }else {
//                jedis.srem(nid + "like", Integer.toString(uid));
//                countForLike++;
//            }
//            Long scardForLike = jedis.scard(nid + "like");
//            Long scardForDislike = jedis.scard(nid + "dislike");
//            likecount = scardForLike - scardForDislike >= 0 ? (int) (scardForLike - scardForDislike) : 0;

        }catch (Exception e){
            throw new RuntimeException("运行异常");
        }finally {
            jedis.close();
        }

        News news = newsMapper.selectNewsByPrimaryKey(nid);

        news.setLikeCount(likecount);
        newsMapper.updateByPrimaryKeySelective(news);
        return likecount;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addDislike(Integer nid, int uid) {
        int likecount = 0;
        Jedis jedis = null;
        try{
            jedis = JedisUtils.getJedis();

        jedis.srem(nid+"like",Integer.toString(uid));
        likecount = Math.toIntExact(jedis.scard(nid + "like"));

//            if(countForDislike%2==0){
//                jedis.sadd(nid + "dislike", Integer.toString(uid));
//                countForDislike++;
//            }else {
//                jedis.srem(nid + "dislike", Integer.toString(uid));
//                countForDislike++;
//            }
//            Long scardForLike = jedis.scard(nid + "like");
//            Long scardForDislike = jedis.scard(nid + "dislike");
//            likecount = scardForLike-scardForDislike>=0? (int) (scardForLike - scardForDislike) :0;

        }catch (Exception e){
            throw new RuntimeException("运行异常");
        }finally {
            jedis.close();
        }


        News news = newsMapper.selectNewsByPrimaryKey(nid);

        news.setLikeCount(likecount);
        newsMapper.updateByPrimaryKeySelective(news);
        return likecount;
    }
}
