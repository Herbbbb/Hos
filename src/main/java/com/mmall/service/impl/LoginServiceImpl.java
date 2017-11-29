package com.mmall.service.impl;

import com.mmall.common.ServerResponse;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.User;
import com.mmall.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.spi.LoginModule;

/**
 * Created by Herb on 2017/11/29.
 */
@Service(value = "loginService")
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserMapper mapper;
    @Override
    public ServerResponse<User> Login(String username, String password) {
        //查询用户名
        int count = mapper.count(username);
        if(count == 0){
            return ServerResponse.createErrorResponse("用户名不存在");
        }
        //验证登录
        //模拟MD5机密
        String MD5Password = password;
        User user = mapper.Login(username,MD5Password);
        if(user == null){
            //密码错误
            return  ServerResponse.createErrorResponse("密码错误");
        }
        //密码置空
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createSuccessResponse("成功登陆",user);
    }
}
