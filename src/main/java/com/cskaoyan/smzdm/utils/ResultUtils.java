package com.cskaoyan.smzdm.utils;

import java.util.HashMap;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 23:44 2018/9/14
 * @Modified By:
 */

public class ResultUtils {
    public static HashMap resultMsg(Object code,Object msg){
        HashMap map = new HashMap();
        map.put("code",code);
        map.put("msg",msg);
        return map;
    }
}
