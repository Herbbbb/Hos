package com.mmall.controller;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Cart;
import com.mmall.service.CartService;
import com.mmall.common.Data;
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
public class CartSelecttAction {

    @Autowired
    private CartService service;
    ServerResponse serverResponse = new ServerResponse();
    Data data = new Data();

    //购物车选中某个商品
    @RequestMapping(value = "select.do", method = RequestMethod.POST)
    public  String addToCart(@RequestParam int productId){
        //选中为1
        Cart cart = service.selectByPrimaryKey(productId);
        cart.setChecked(1);
        service.updateByPrimaryKeySelective(cart);
        return "redirect:/cart/list.do";
    }
}
