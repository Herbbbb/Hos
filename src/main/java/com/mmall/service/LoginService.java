package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * Created by Herb on 2017/11/29.
 */
public interface LoginService {

    //根据用户名,密码查询
    ServerResponse<User> Login(String username,String password);
}
