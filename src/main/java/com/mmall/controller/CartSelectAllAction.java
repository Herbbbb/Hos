package com.mmall.controller;

import com.mmall.pojo.Cart;
import com.mmall.service.CartService;
import com.mmall.vo.CartProductVoList;
import com.mmall.vo.Data;
import com.mmall.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by Herb on 2017/11/28.
 */
@Controller
@RequestMapping(value = "cart")
public class CartSelectAllAction {

    @Autowired
    private CartService service;
    Message message = new Message();
    Data data = new Data();

    //购物车选中某个商品
    @RequestMapping(value = "select_all.do", method = RequestMethod.GET)
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
