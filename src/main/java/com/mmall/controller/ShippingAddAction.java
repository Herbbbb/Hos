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
public class ShippingAddAction {

    @Autowired
    private ShippingService service;

    @RequestMapping(value="add.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<Shipping> addShipping(Integer userid,String receiverName,String receiverPhone, String receiverMobile,
     String receiverProvince,String receiverCity,String receiverDistrict,String receiverAddress,String receiverZip){
        //新加信息
        Shipping shipping = new Shipping();
        shipping.setUserId(userid);
        shipping.setReceiverName(receiverName);
        shipping.setReceiverPhone(receiverPhone);
        shipping.setReceiverMobile(receiverMobile);
        shipping.setReceiverProvince(receiverProvince);
        shipping.setReceiverCity(receiverCity);
        shipping.setReceiverDistrict(receiverDistrict);
        shipping.setReceiverAddress(receiverAddress);
        shipping.setReceiverZip(receiverZip);
        int i= service.insertSelective(shipping);
       if(i>0){
           ServerResponse<Shipping> response = new ServerResponse<>();
           response.setData(shipping);
           return response.createSuccessResponse("新建地址成功",shipping);
       }
        return ServerResponse.createErrorResponse("新建地址失败");
    }
}
