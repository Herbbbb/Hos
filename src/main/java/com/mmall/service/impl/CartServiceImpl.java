package com.mmall.service.impl;

import com.mmall.dao.CartMapper;
import com.mmall.pojo.Cart;
import com.mmall.service.CartService;
import com.mmall.common.CartProductVoList;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Herb on 2017/11/27.
 */
@Service(value = "cartService")
public class CartServiceImpl implements CartService{

    @Autowired
    private CartMapper mapper;

    @Override
    public int updateByPrimaryKeySelective(Cart cart) {
        return mapper.updateByPrimaryKeySelective(cart);
    }

    @Override
    public int findUserIdByUsername(String username) {
        return mapper.findUserIdByUsername(username);
    }

    @Override
    public List<CartProductVoList> findAll(@Param("userId") Integer userId) {
        return mapper.findAll(userId);
    }

    @Override
    public Cart findIfRepeat(@Param("productId") int productId) {
        return mapper.findIfRepeat(productId);
    }

    @Override
    public int insertSelective(Cart cart) {
        return mapper.insertSelective(cart);
    }

    @Override
    public int deleteByPrimaryKey(Integer ProID) {
        return mapper.deleteByPrimaryKey(ProID);
    }

    @Override
    public Cart selectByPrimaryKey(Integer ProId) {
        return mapper.selectByPrimaryKey(ProId);
    }

    @Override
    public int totalQuantity() {
        return mapper.totalQuantity();
    }
}
