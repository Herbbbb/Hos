package com.mmall.controller;

import com.mmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Herb on 2017/11/28.
 */
@Controller
@RequestMapping(value = "cart")
public class CartDeleteProductAction {

    @Autowired
    private CartService service;

    //购物车List列表
    @RequestMapping(value = "delete_product.do", method = RequestMethod.POST)
    public  String addToCart(@RequestParam int productId){
        //单个删除
        service.deleteByPrimaryKey(productId);
        return "redirect:/cart/list.do";
    }
}
