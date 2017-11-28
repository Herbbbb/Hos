package com.mmall.dao;

import com.mmall.pojo.Cart;
import com.mmall.vo.CartProductVoList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {

    //插入
    int insert(Cart record);

    //更新
    int updateByPrimaryKey(Cart cart);
    //更新--SQL拼接
    int updateByPrimaryKeySelective(Cart cart);

    //功能一：购物车List列表
    //根据页面username查找id
    int findUserIdByUsername(String username);
    //购物车List列表
    List<CartProductVoList> findAll(@Param("userId")Integer userId);

    //功能二：添加商品到购物车
    //判断product是否重复,重复则在原有购物项数量上追加一
    Cart findIfRepeat(@Param("productId") int productId);
    //没有重复则添加新的购物项
    //展示的时候涉及多表联查，插入的时候只插入Cart的信息，再调用功能一的方法展示所有
    //ProID和quantity由前台传入--@RequsetBody放在Aaction形参对应位置：cart.setProduct(形参1)，cart.setQuantity(形参2)
    int insertSelective(Cart cart);

    //功能三：移除购物车某个产品
    //根据产品ID删除--删除的是商品而不是购物项
    //再直接调用功能一的方法
    int deleteByPrimaryKey(Integer ProID);

    //功能四：更新购物车某个产品数
    //点击增加/减少按钮--调用功能二方法
    //ID查询--通过Set完成增加减少
    //用来set改变数量
    //再直接调用功能一的方法
    Cart selectByPrimaryKey(Integer ProId);


    //功能五：购物车选中某个商品，调用ProID查Cart方法，set-Check完成
    //功能六：购物车取消选中某个商品，调用ProID查Cart方法，set-Check完成
    //功能七：购物车全选，调用findAll方法，set-Check完成
    //功能八：购物车取消全选，调用findAll方法，set-Check完成

    //功能九：查询在购物车里的所有产品总数量
    int totalQuantity();
}