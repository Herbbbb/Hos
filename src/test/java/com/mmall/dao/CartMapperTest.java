package com.mmall.dao;

import com.mmall.pojo.Cart;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by Herb on 2017/11/27.
 */
public class CartMapperTest {

    ApplicationContext ctx = null;
    CartMapper mapper;
    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        mapper = (CartMapper) ctx.getBean("cartMapper");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test is over");
    }

    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testInsertSelective() throws Exception {

    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        Cart cart = mapper.selectByPrimaryKey(126);
        System.out.println(cart);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {

    }
}