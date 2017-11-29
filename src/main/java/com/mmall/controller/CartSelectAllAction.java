package com.mmall.controller;

import com.mmall.service.CartService;
import com.mmall.common.CartProductVoList;
import com.mmall.common.Data;
import com.mmall.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * Created by Herb on 2017/11/28.
 */
@Controller
@RequestMapping(value = "cart")
public class CartSelectAllAction {

    @Autowired
    private CartService service;
    ServerResponse serverResponse = new ServerResponse();
    Data data = new Data();

    //购物车选中某个商品
    @RequestMapping(value = "select_all.do", method = RequestMethod.POST)
    public  String addToCart(){
        //模拟Session中获取的userID
        List<CartProductVoList> lists = service.findAll(21);
        for(CartProductVoList vo : lists){
            //全选为1
            vo.setProductChecked(1);
        }
        return "redirect:/cart/list.do";
    }
}
