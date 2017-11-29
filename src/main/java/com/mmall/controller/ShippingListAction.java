package com.mmall.controller;

import com.mmall.common.Data;
import com.mmall.common.ServerResponse;
import com.mmall.common.ShippingCommon;
import com.mmall.pojo.Shipping;
import com.mmall.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Herb on 2017/11/29.
 */
@Controller
@RequestMapping(value = "shipping")
public class ShippingListAction {

    @Autowired
    private ShippingService service;
    ServerResponse<ShippingCommon> serverResponse = new ServerResponse<ShippingCommon>();
    ShippingCommon common = new ShippingCommon();

    @RequestMapping(value="list.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<ShippingCommon> addShipping() {
        List<Shipping> lists = service.findAll();

        if(lists != null) {
            common.setShippings(lists);
            serverResponse.setData(common);
            return ServerResponse.createSuccessMessageResponse(common);
        }
        return ServerResponse.createErrorResponse("请登陆之后查询");

    }
}
