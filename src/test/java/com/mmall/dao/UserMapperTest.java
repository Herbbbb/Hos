package com.mmall.dao;

import com.mmall.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by Herb on 2017/11/29.
 */
public class UserMapperTest {

    ApplicationContext ctx = null;
    UserMapper mapper;
    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        mapper = (UserMapper) ctx.getBean("userMapper");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCount() throws Exception {
        int i = mapper.count("admin");
        System.out.println(i);
    }

    @Test
    public void testLogin() throws Exception {
        User user = mapper.Login("admin","427338237BD929443EC5D48E24FD2B1A");
        System.out.println(user);
    }
}