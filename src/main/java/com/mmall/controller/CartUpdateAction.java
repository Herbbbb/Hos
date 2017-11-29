package com.mmall.controller;

import com.mmall.pojo.Cart;
import com.mmall.service.CartService;
import com.mmall.common.Data;
import com.mmall.common.ServerResponse;
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
public class CartUpdateAction {

    @Autowired
    private CartService service;
    ServerResponse serverResponse = new ServerResponse();
    Data data = new Data();

    //更新购物车某个产品数量
    @RequestMapping(value = "update.do", method = RequestMethod.POST)
    public String updateToCart(@RequestParam int productId, @RequestParam int count){
        Cart cart = service.findIfRepeat(productId);
        //说明已有该购物项,增加quantity+1即可--也不用额外判断是否重复
        Cart cart1 = service.selectByPrimaryKey(productId);
        //增加
        cart1.setQuantity(cart.getQuantity()+count);
        //前台判断数量和库存的关系，这里不做处理
        service.updateByPrimaryKeySelective(cart1);
        return "redirect:/cart/list.do";
    }
}
