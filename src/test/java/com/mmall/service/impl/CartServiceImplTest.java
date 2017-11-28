//package com.mmall.service.impl;
//
//import com.mmall.pojo.Cart;
//import com.mmall.service.CartService;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
// * Created by Herb on 2017/11/28.
// */
//public class CartServiceImplTest {
//
//    ApplicationContext ctx = null;
//    CartService service;
//    @Before
//    public void setUp() throws Exception {
//        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        service = (CartService) ctx.getBean("cartService");
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        System.out.println("Test is over");
//    }
//
//    @Test
//    public void testFindUserIdByUsername() throws Exception {
//        int id = service.findUserIdByUsername("scott");
//        List<Resu> lists = service.findAll(id);
//        for(Cart cart : lists){
//            System.out.println(cart);
//        }
//    }
//
//    @Test
//    public void testFindAll() throws Exception {
//        List<Cart> lists = service.findAll(21);
//        for(Cart cart : lists){
//            System.out.println(cart);
//        }
//    }
//
//    @Test
//    public void testFindIfRepeat() throws Exception {
//        Cart cart = service.findIfRepeat(21,26);
//        System.out.println(cart);
//    }
//
//    @Test
//    public void testInsertSelective() throws Exception {
//        Cart cart = new Cart();
//        //模拟前台传入的三个参数-userID proID quantity
//        cart.setUserId(21);
//        cart.setProductId(29);
//        cart.setCreateTime(new Date());
//        cart.setUpdateTime(new Date());
//        //验证是否重复
//        Cart cart1 = service.findIfRepeat(cart.getUserId(),cart.getProductId());
//        if(cart1 != null){
//            //没有事务提交不上去  但是数据增加了 之后在Service层处理
//            cart1.setQuantity(cart1.getQuantity()+1);
//            System.out.println(cart1.getQuantity());
//            testFindAll();
//        }else {
//            //新增一条Cart记录
//            cart.setQuantity(5);
//            service.insertSelective(cart);
//            //增加之后，调用FindAll方法显示该用户所有购物项，传参uesrID--
//        }
//    }
//
//    @Test
//    public void testDeleteByPrimaryKey() throws Exception {
//
//    }
//
//    @Test
//    public void testSelectByPrimaryKey() throws Exception {
//        Cart cart = service.selectByPrimaryKey(28);
//        System.out.println(cart);
//    }
//
//    @Test
//    public void testTotalQuantity() throws Exception {
//        int total = service.totalQuantity();
//        System.out.println(total);
//    }
//}