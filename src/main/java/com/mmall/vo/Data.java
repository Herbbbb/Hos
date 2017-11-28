package com.mmall.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mmall.pojo.Cart;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Herb on 2017/11/28.
 */
public class Data implements Serializable{
    private List<CartProductVoList> cartProductVoList;
    private boolean allChecked;
    private BigDecimal cartTotalPrice;

    public Data() {
    }

    public Data(List<CartProductVoList> cartProductVoList, boolean allChecked, BigDecimal cartTotalPrice) {
        this.cartProductVoList = cartProductVoList;
        this.allChecked = allChecked;
        this.cartTotalPrice = cartTotalPrice;
    }

    public List<CartProductVoList> getCartProductVoList() {
        return cartProductVoList;
    }

    public void setCartProductVoList(List<CartProductVoList> cartProductVoList) {
        this.cartProductVoList = cartProductVoList;
    }

    public boolean isAllChecked() {
        return allChecked;
    }

    public void setAllChecked(boolean allChecked) {
        this.allChecked = allChecked;
    }

    public BigDecimal getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    @Override
    public String toString() {
        return "Data{" +
                "cartProductVoList=" + cartProductVoList.size() +
                ", allChecked=" + allChecked +
                ", cartTotalPrice=" + cartTotalPrice +
                '}';
    }
}
