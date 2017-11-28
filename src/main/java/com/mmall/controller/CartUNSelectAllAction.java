package com.mmall.controller;

import com.mmall.service.CartService;
import com.mmall.vo.CartProductVoList;
import com.mmall.vo.Data;
import com.mmall.vo.Message;
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
public class CartUNSelectAllAction {

    @Autowired
    private CartService service;
    Message message = new Message();
    Data data = new Data();

    //购物车选中某个商品
    @RequestMapping(value = "un_select_all.do", method = RequestMethod.GET)
    public String UNSelectAllToCart(){
        String username = " ";
        if(username != null && username != " ") {
            //模拟Session中获取的userID
            List<CartProductVoList> lists = service.findAll(21);
            for (CartProductVoList vo : lists) {
                //全选为1
                vo.setProductChecked(0);
            }
            return "redirect:/cart/list.do";
        }else{
            message.setStatus(10);
            message.setMsg("用户未登录,请登录");
            return message.toString();
        }
    }
}
