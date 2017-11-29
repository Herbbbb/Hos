package com.mmall.service;

import com.mmall.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Herb on 2017/11/28.
 */
public interface ShippingService {
    Shipping selectByPrimaryKey(Integer id);
    //功能一：添加地址--
    int insert(Shipping record);
    //功能一：添加地址--SQL拼接
    int insertSelective(Shipping record);

    //功能二：删除地址--根据ID
    int deleteByPrimaryKey(Integer id);

    //功能三：登录状态更新地址
    int updateByPrimaryKeySelective(Shipping record);
    int updateByPrimaryKey(Shipping record);

    //功能四：选中查看具体的地址
    Shipping findDetail(@Param("id") Integer id);
    //功能五：地址列表--即查看所有地址
    List<Shipping> findAll();
}
