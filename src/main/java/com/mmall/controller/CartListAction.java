package com.mmall.controller;

import com.mmall.common.ServerResponse;
import com.mmall.service.CartService;
import com.mmall.common.CartProductVoList;
import com.mmall.common.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;
/**
 * Created by Herb on 2017/11/27.
 */
@Controller
@RequestMapping(value="cart")
public class CartListAction {

    @Autowired
    private CartService service;
    ServerResponse<Data> serverResponse = new ServerResponse<Data>();
    Data data = new Data();

    //购物车List列表
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    //本来是写在形参里的@RequestParam String username 方便后面测试线拿出来
    public @ResponseBody ServerResponse<Data> getCart() {
        //模拟Session获取的用户登陆信息
        String username = "scott";
        //未登录的情况
        if (username == null || username == " ") {
            //方法一
            // serverResponse.setMsg("用户尚未登录,请登录");
            //serverResponse.setStatus(10);
            // return serverResponse;
            //方法二
//            ServerResponse.createErrorResponse();
//            ServerResponse.createErrorResponse("用户尚未登录,请登录");
            //方法三
            return  ServerResponse.createErrorCodeMsg(10,"用户尚未登录,请登录");

        } else {
            //用户已经登录
            //根据页面用户名查找ID
            int id = service.findUserIdByUsername(username);
            //查找该用户所有购物项
            List<CartProductVoList> lists = service.findAll(id);
            if (lists != null) {
                //satus
                serverResponse.setStatus(0);//表示查询成功
                //data
                BigDecimal totalPrice = new BigDecimal("0.00");
                //计算总价
                for (CartProductVoList volist : lists) {
                    //总价
                    totalPrice = volist.getProductTotalPrice().add(totalPrice);
                    volist.setLimitQuantity("LIMIT_NUM_SUCCESS");
                }
                //封装CartProductVoList
                data.setCartProductVoList(lists);
                //设置allChecked
                data.setAllChecked(true);
                //设置总价
                data.setCartTotalPrice(totalPrice);
                //将Data信息封装在Message里
                serverResponse.setData(data);
            }else{
                serverResponse.setStatus(1);//表示查询失败
            }
            return serverResponse;
        }
    }
}
