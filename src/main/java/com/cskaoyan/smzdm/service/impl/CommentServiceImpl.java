package com.cskaoyan.smzdm.service.impl;

import com.cskaoyan.smzdm.domain.Comment;
import com.cskaoyan.smzdm.domain.News;
import com.cskaoyan.smzdm.domain.VO.Commentvo;
import com.cskaoyan.smzdm.domain.VO.NewsVO;
import com.cskaoyan.smzdm.mapper.CommentMapper;
import com.cskaoyan.smzdm.mapper.NewsMapper;
import com.cskaoyan.smzdm.service.CommentService;
import com.cskaoyan.smzdm.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 20:37 2018/9/14
 * @Modified By:
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    NewsMapper newsMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public HashMap addComment(Comment comment) {
        int insert = commentMapper.insert(comment);
        HashMap map = null;
        if(insert==1){
            News news = newsMapper.selectNewsByPrimaryKey(comment.getNid());
            news.setCommentCount(news.getCommentCount()+1);
            newsMapper.updateByPrimaryKeySelective(news);
            map = ResultUtils.resultMsg(0, "添加评论成功");
        }else {
            map = ResultUtils.resultMsg(0, "添加评论失败");
        }
        return map;
    }

    @Override
    public List<Commentvo> findAllCommentByNid(Integer nid) {
        List<Commentvo> comments = commentMapper.selectAllCommentByNid(nid);
        return comments;
    }
}
