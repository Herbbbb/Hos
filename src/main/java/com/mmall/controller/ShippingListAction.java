package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.common.Data;
import com.mmall.common.ServerResponse;
import com.mmall.common.ShippingCommon;
import com.mmall.pojo.Shipping;
import com.mmall.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    public ServerResponse<PageInfo> addShipping(HttpServletRequest request,
                                                      @RequestParam(required=true,defaultValue="1") Integer page,
                                                      @RequestParam(required=false,defaultValue="10") Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Shipping> lists = service.findAll();
        PageInfo<Shipping> p=new PageInfo<Shipping>(lists);
        request.setAttribute("page", p);
        if(lists != null) {
            return ServerResponse.createSuccessMessageResponse(p);
        }
        return ServerResponse.createErrorResponse("请登陆之后查询");
    }
}
