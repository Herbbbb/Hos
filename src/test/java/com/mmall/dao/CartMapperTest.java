package com.mmall.dao;

import com.mmall.pojo.Cart;
import com.mmall.vo.CartProductVoList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

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
        mapper = (CartMapper) ctx.getBean(CartMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test is over");
    }

    @Test
    public void testDeleteByPrimaryKey() throws Exception {
       int i =  mapper.deleteByPrimaryKey(29);
        System.out.println("影响行数：" + i);
        //之后在调用findAll方法，传参userID
    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testIfRepeat(){
        Cart cart = mapper.findIfRepeat(26);
        System.out.println(cart);
    }
    @Test
    public void testInsertSelective() throws Exception {
        Cart cart = new Cart();
        //模拟前台传入的三个参数-userID proID quantity
        cart.setUserId(21);
        cart.setProductId(29);
        cart.setCreateTime(new Date());
        cart.setUpdateTime(new Date());
        //验证是否重复
        Cart cart1 = mapper.findIfRepeat(cart.getProductId());
        if(cart1 != null){
            //没有事务提交不上去  但是数据增加了 之后在Service层处理
            cart1.setQuantity(cart1.getQuantity()+1);
            System.out.println(cart1.getQuantity());
            testFindAll();
        }else {
            //新增一条Cart记录
            cart.setQuantity(5);
            mapper.insertSelective(cart);
            //增加之后，调用FindAll方法显示该用户所有购物项，传参uesrID--
        }
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        Cart cart = mapper.selectByPrimaryKey(126);
        System.out.println(cart);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {
        Cart cart = mapper.selectByPrimaryKey(27);
        cart.setQuantity(8);
        System.out.println(cart);
       mapper.updateByPrimaryKeySelective(cart);
    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {
        Cart cart = new Cart();
        cart.setProductId(27);
        cart.setQuantity(99);
        mapper.updateByPrimaryKeySelective(cart);
    }
    @Test
    public void testFindAll(){
        List<CartProductVoList> lists = mapper.findAll(21);
        for(CartProductVoList result : lists){
            System.out.println(result);
        }
    }

    @Test
    public void testfindUserIdByUsername(){
        int id = mapper.findUserIdByUsername("scott");
        List<CartProductVoList> lists = mapper.findAll(id);
        for(CartProductVoList result : lists){
            System.out.println(result);
        }
    }

    @Test
    public void testfindQuantityById(){
        //形参ProId
        Cart cart = mapper.selectByPrimaryKey(28);
        int quantity = cart.getQuantity();
        //以下都可以实现数量增减-check的1-0改变 但是没有事务不会改变数据库
        //当点击增加按钮--quantity暂由下面的1代替，Action处理
        cart.setQuantity(quantity+1);
        System.out.println(cart + "------------------------");
        //当点击减少按钮
//        cart.setQuantity(quantity-1);
//        System.out.println(cart + "------------------------");
        //选中某个商品
//        cart.setChecked(1);
//        System.out.println(cart + "=============");
        //q取消选中某个商品
        cart.setChecked(0);
        System.out.println(cart + "=============");
    }

    @Test
    public void testCheck(){
        List<CartProductVoList> lists = mapper.findAll(21);
        for(CartProductVoList result : lists){
            result.setProductChecked(0);
            //cart.setChecked(1);
            System.out.println(result);
        }
    }

    @Test
    public void testtotalQuantity(){
        int total = mapper.totalQuantity();
        System.out.println(total);
    }
}