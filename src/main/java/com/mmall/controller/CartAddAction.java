package com.mmall.controller;

import com.mmall.pojo.Cart;
import com.mmall.service.CartService;
import com.mmall.vo.Data;
import com.mmall.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by Herb on 2017/11/28.
 */
@Controller
@RequestMapping(value = "cart")
public class CartAddAction {

    @Autowired
    private CartService service;
    Message message = new Message();
    Data data = new Data();

    //购物车List列表
    @RequestMapping(value = "add.do", method = RequestMethod.GET)
    public String addToCart(@RequestParam int productId, @RequestParam int count) {
        Cart cart = service.findIfRepeat(productId);
        //模拟session获取登陆信息
        if (cart != null) {
            //说明已有该购物项,增加quantity+1即可--可以进入判断但是数量加不上去
            Cart cart1 = service.selectByPrimaryKey(productId);
            cart1.setQuantity(cart.getQuantity() + count);
            service.updateByPrimaryKeySelective(cart1);
        } else {
            //没有该购物项
            Cart cart2 = new Cart();
            cart2.setQuantity(count);
            //后面这里的UserId从Session获取
            cart2.setUserId(21);
            //添加
            cart2.setChecked(1);
            cart2.setProductId(productId);
            cart2.setCreateTime(new Date());
            cart2.setUpdateTime(new Date());
            service.insertSelective(cart2);
            return "redirect:/cart/list.do";
        }
        return "";
    }
}
