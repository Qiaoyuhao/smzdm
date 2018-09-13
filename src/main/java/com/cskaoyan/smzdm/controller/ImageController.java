package com.cskaoyan.smzdm.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
import com.cskaoyan.smzdm.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 23:12 2018/9/12
 * @Modified By:
 */

@Controller
public class ImageController {

    @Autowired
    ImageService imageService;

    @RequestMapping("/uploadImage")
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile file){
        HashMap resultMap = imageService.uploadImage(file);
        String toJSONString = JSONUtils.toJSONString(resultMap);
        return toJSONString;

    }



}
