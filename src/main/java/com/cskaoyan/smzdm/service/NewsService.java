package com.cskaoyan.smzdm.service;

import com.cskaoyan.smzdm.domain.News;
import com.cskaoyan.smzdm.domain.VO.NewsVO;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 14:57 2018/9/13
 * @Modified By:
 */
public interface NewsService {
    HashMap addNews(News news);

    List<News> findAllNews();

    NewsVO findNewsById(String id);

    int addLike(Integer newsId, int uid);

    int addDislike(Integer newsId, int uid);
}
