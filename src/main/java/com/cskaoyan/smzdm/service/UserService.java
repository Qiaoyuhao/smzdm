package com.cskaoyan.smzdm.service;

import com.cskaoyan.smzdm.domain.User;

import java.util.HashMap;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 9:58 2018/9/12
 * @Modified By:
 */
public interface UserService {

    HashMap addUser(User user);

    HashMap login(User user);

    HashMap findById(String id);
}
