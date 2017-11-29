package com.mmall.common;

import com.mmall.pojo.Shipping;

import java.util.List;

/**
 * Created by Herb on 2017/11/29.
 */
public class ShippingCommon {

    private List<Shipping> shippings;

    public ShippingCommon(List<Shipping> shippings) {
        this.shippings = shippings;
    }

    public ShippingCommon() {
    }

    public List<Shipping> getShippings() {
        return shippings;
    }

    public void setShippings(List<Shipping> shippings) {
        this.shippings = shippings;
    }
}
