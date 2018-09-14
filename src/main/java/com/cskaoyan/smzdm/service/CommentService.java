package com.cskaoyan.smzdm.service;

import com.cskaoyan.smzdm.domain.Comment;
import com.cskaoyan.smzdm.domain.VO.Commentvo;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 20:37 2018/9/14
 * @Modified By:
 */
public interface CommentService {

    HashMap addComment(Comment comment);

    List<Commentvo> findAllCommentByNid(Integer nid);
}
