package com.mmall.controller;

import com.mmall.service.CartService;
import com.mmall.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Herb on 2017/11/28.
 */
@Controller
@RequestMapping(value = "cart")
public class CartCountAction {

    @Autowired
    private CartService service;
    Result result = new Result();

    //购物车List列表
    @RequestMapping(value = "get_cart_product_count.do", method = RequestMethod.POST)
    public @ResponseBody Result addToCart(){
        //从Session获取登陆，下面只是模拟一下
        String username= " ";
        int total = service.totalQuantity();
        if(username != null && username != " "){
            result.setStatus(0);
            result.setData(0);
        }else{
            result.setStatus(10);
            result.setMsg("出现异常");
        }
        return result;
    }
}
