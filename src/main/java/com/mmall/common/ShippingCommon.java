package com.mmall.common;

import com.mmall.pojo.Shipping;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Herb on 2017/11/29.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class ShippingCommon implements Serializable{

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
