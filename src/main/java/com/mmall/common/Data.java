package com.mmall.common;

import com.mmall.common.CartProductVoList;
import com.mmall.pojo.Shipping;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Herb on 2017/11/28.
 */
public class Data implements Serializable{
    private List<CartProductVoList> cartProductVoList;
    private List<Shipping> shippings;
    private boolean allChecked;
    private BigDecimal cartTotalPrice;

    public Data() {
    }

    public Data(List<CartProductVoList> cartProductVoList, boolean allChecked, BigDecimal cartTotalPrice) {
        this.cartProductVoList = cartProductVoList;
        this.allChecked = allChecked;
        this.cartTotalPrice = cartTotalPrice;
    }

    public Data(List<CartProductVoList> cartProductVoList, List<Shipping> shippings, boolean allChecked, BigDecimal cartTotalPrice) {
        this.cartProductVoList = cartProductVoList;
        this.shippings = shippings;
        this.allChecked = allChecked;
        this.cartTotalPrice = cartTotalPrice;
    }

    public List<Shipping> getShippings() {
        return shippings;
    }

    public void setShippings(List<Shipping> shippings) {
        this.shippings = shippings;
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
                "cartProductVoList=" + cartProductVoList +
                ", shippings=" + shippings +
                ", allChecked=" + allChecked +
                ", cartTotalPrice=" + cartTotalPrice +
                '}';
    }
}
