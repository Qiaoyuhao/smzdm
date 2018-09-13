package com.cskaoyan.smzdm.service.impl;

import com.cskaoyan.smzdm.domain.User;
import com.cskaoyan.smzdm.mapper.UserMapper;
import com.cskaoyan.smzdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 9:59 2018/9/12
 * @Modified By:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * @Author: QiaoYuhao
     * @Description: 注册的操作
     * @param:  user 待添加的User对象
     * @return: map 返回添加操作的结果
     */
    @Override
    public HashMap addUser(User user) {
        HashMap map = new HashMap();
        if(userMapper.selectByUsername(user.getUsername())!=null){
            map.put("code",1);
            map.put("msg","用户名已被使用");
        }else {
            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png",new Random().nextInt(100)));
            int insert = userMapper.insert(user);
            if(insert==1){
                map.put("code",0);
                map.put("msg","注册成功");
            }else{
                map.put("code",1);
                map.put("msg","注册失败");
            }
        }
        return map;
    }


    /**
     * @Author: QiaoYuhao
     * @Description: 登录验证的操作
     * @param:  user 登录待check的User对象
     * @return: map 返回check操作的结果
     */

    @Override
    public HashMap login(User user) {
        HashMap map = new HashMap();
        User userByFind = userMapper.selectByUsernameAndPassword(user);
        if(userByFind!=null){
            map.put("code",0);
            map.put("msg","登录成功");
            map.put("user",userByFind);
        }else {
            map.put("code",1);
            map.put("msg","用户名或密码错误");
        }
        return map;
    }

    @Override
    public HashMap findById(String id) {
        User user = userMapper.selectByPrimaryKey(Integer.valueOf(id));
        HashMap map = new HashMap();
        map.put("user",user);
        return map;
    }

    @Override
    public User checkUsernameAndPassword(String username, String password) {
        User user = new User(username,password);
        User userByFind = userMapper.selectByUsernameAndPassword(user);
        return userByFind;
    }
}
