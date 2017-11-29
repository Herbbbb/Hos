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
public class ShippingUpdateAction {

    @Autowired
    private ShippingService service;

    @RequestMapping(value="update.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<Shipping> addShipping(Integer id,String receiverName,String receiverPhone, String receiverMobile,
     String receiverProvince,String receiverCity,String receiverDistrict,String receiverAddress,String receiverZip){
        //新加信息
        Shipping shipping = new Shipping();
        shipping.setId(id);
        shipping.setReceiverName(receiverName);
        shipping.setReceiverPhone(receiverPhone);
        shipping.setReceiverMobile(receiverMobile);
        shipping.setReceiverProvince(receiverProvince);
        shipping.setReceiverCity(receiverCity);
        shipping.setReceiverDistrict(receiverDistrict);
        shipping.setReceiverAddress(receiverAddress);
        shipping.setReceiverZip(receiverZip);
        int i= service.updateByPrimaryKeySelective(shipping);
       if(i==1){
           return ServerResponse.createSuccessResponse("更新地址成功");
       }
        return ServerResponse.createSuccessResponse("更新地址成功");
    }
}
