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
public class ShippingDeleteAction {

    @Autowired
    private ShippingService service;

    @RequestMapping(value="del.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Shipping> addShipping(Integer shippingId) {
        int i = service.deleteByPrimaryKey(shippingId);
        if (i == 1) {
            return ServerResponse.createSuccessResponse("删除地址成功");
        }
        return ServerResponse.createErrorResponse("删除地址失败");
    }
}
