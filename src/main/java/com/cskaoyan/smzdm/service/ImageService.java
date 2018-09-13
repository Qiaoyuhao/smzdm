package com.cskaoyan.smzdm.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 23:36 2018/9/12
 * @Modified By:
 */
public interface ImageService {
    HashMap uploadImage(MultipartFile uploadFile);
}
