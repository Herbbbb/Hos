package com.mmall.service.impl;

import com.mmall.pojo.Shipping;
import com.mmall.service.ShippingService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Herb on 2017/11/28.
 */
public class ShippingServiceImplTest {

    ApplicationContext ctx = null;
    ShippingService service;
    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = (ShippingService) ctx.getBean("shippingService");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test is over");
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        Shipping shipping = service.selectByPrimaryKey(7);
        System.out.println(shipping);
    }

    @Test
    public void testInsertSelective() throws Exception {
        Shipping shipping = new Shipping();
        shipping.setUserId(23);
        shipping.setReceiverName("Herb");
        shipping.setReceiverPhone("123");
        shipping.setReceiverMobile("1234567890");
        shipping.setReceiverProvince("河南");
        shipping.setReceiverCity("信阳市");
        shipping.setReceiverDistrict("浉河区");
        shipping.setReceiverZip("673290");
        shipping.setCreateTime(new Date());
        shipping.setUpdateTime(new Date());
        service.insertSelective(shipping);
        System.out.println(shipping);
    }

    @Test
    public void testDeleteByPrimaryKey() throws Exception {
        int i = service.deleteByPrimaryKey(31);
        System.out.println("影响行数："+i);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {
        Shipping shipping = new Shipping();
        shipping.setId(7);
        shipping.setReceiverName("Rush");
        service.updateByPrimaryKeySelective(shipping);
        System.out.println(shipping);
    }

    @Test
    public void testFindDetail() throws Exception {
        Shipping shipping = service.findDetail(7);
        System.out.println(shipping);
    }

    @Test
    public void testFindAll() throws Exception {
        List<Shipping> lists = service.findAll();
        for(Shipping shipping : lists){
            System.out.println(shipping);
        }
    }
}