package com.mmall.dao;

import com.mmall.pojo.Shipping;
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
public class ShippingMapperTest {

    ApplicationContext ctx = null;
    ShippingMapper mapper;
    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        mapper = (ShippingMapper) ctx.getBean("shippingMapper");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test is over");
    }

    @Test
    public void testInsertSelective() throws Exception {
        Shipping shipping = new Shipping();
        shipping.setUserId(21);
        shipping.setReceiverName("Herb");
        shipping.setReceiverPhone("123");
        shipping.setReceiverMobile("1234567890");
        shipping.setReceiverProvince("河南");
        shipping.setReceiverCity("信阳市");
        shipping.setReceiverDistrict("浉河区");
        shipping.setReceiverZip("673290");
        shipping.setCreateTime(new Date());
        shipping.setUpdateTime(new Date());
        mapper.insertSelective(shipping);
        System.out.println(shipping);
    }

    @Test
    public void testDeleteByPrimaryKey() throws Exception {
        int i = mapper.deleteByPrimaryKey(30);
        System.out.println(i);
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        Shipping shipping = mapper.selectByPrimaryKey(7);
        System.out.println(shipping);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {
        Shipping shipping = new Shipping();
        shipping.setId(35);
        shipping.setReceiverName("Herb");
        mapper.updateByPrimaryKeySelective(shipping);
        System.out.println(shipping);
    }


    @Test
    public void testFindAll() throws Exception {
        List<Shipping> lists = mapper.findAll();
        for(Shipping shipping : lists){
            System.out.println(shipping);
        }

    }@Test
    public void testFindDetail() throws Exception {

        Shipping lists = mapper.findDetail(7);
        System.out.println(lists);

    }
}