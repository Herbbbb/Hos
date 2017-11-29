package com.mmall.controller;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Herb on 2017/11/29.
 */
@Controller
@RequestMapping(value = "/user/")
public class UserLoginAction {
    @Autowired
    private LoginService service;
    @RequestMapping(value="login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> getLogin(String username, String password, HttpSession session){

        ServerResponse<User> response = service.Login(username,password);
        if(response.isSuccess()){
            //说明有该记录
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

}
