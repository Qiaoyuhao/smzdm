package com.cskaoyan.smzdm.service.impl;

import com.cskaoyan.smzdm.service.ImageService;
import com.cskaoyan.smzdm.utils.ResultUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 23:37 2018/9/12
 * @Modified By:
 */

@Service
public class ImageServiceImpl implements ImageService {


    @Override
    public HashMap uploadImage(MultipartFile uploadFile) {
        HashMap map = new HashMap();
        String newFileName = null;
        try {
            //获取原始文件名
            String originalFilename = uploadFile.getOriginalFilename();

            //UUID生成新文件名，并添加文件后缀
            String uuid = UUID.randomUUID().toString();
            newFileName = uuid + originalFilename.substring(originalFilename.lastIndexOf("."));

            //新文件路径（在server.xml里映射 /pic/ 路径）
            String realPath = "E:\\upload\\temp\\img\\";
            File newFile = new File(realPath+newFileName);

            //写入上传文件
            uploadFile.transferTo(newFile);
            map = ResultUtils.resultMsg(0, "http://localhost/"+newFileName);
            return map;

        } catch (IOException e) {
            e.printStackTrace();
            map = ResultUtils.resultMsg(1, "文件上传出现问题");
            return map;
        }
    }
}
