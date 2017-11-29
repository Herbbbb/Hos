package com.mmall.controller;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;
import com.mmall.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Herb on 2017/11/29.
 */
@Controller
@RequestMapping(value = "shipping")
public class ShippingSelectAction {

    @Autowired
    private ShippingService service;

    @RequestMapping(value="select.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Shipping> addShipping(Integer shippingId){
        //新加信息
        Shipping shipping = service.selectByPrimaryKey(shippingId);
       if(shipping != null){
           return ServerResponse.createSuccessMessageResponse(shipping);
       }
        return ServerResponse.createErrorResponse("请登录之后查询");
    }
}
