package com.cskaoyan.smzdm.service;

import com.cskaoyan.smzdm.domain.News;

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

}
