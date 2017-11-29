package com.mmall.service.impl;

import com.mmall.dao.ShippingMapper;
import com.mmall.pojo.Shipping;
import com.mmall.service.ShippingService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Herb on 2017/11/28.
 */
@Service(value="shippingService")
public class ShippingServiceImpl implements ShippingService{

    @Autowired
    private ShippingMapper mapper;
    @Override
    public Shipping selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Shipping record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Shipping record) {
        return mapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Shipping record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Shipping record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public Shipping findDetail(@Param("id") Integer id) {
        return mapper.findDetail(id);
    }

    @Override
    public List<Shipping> findAll() {
        return mapper.findAll();
    }
}
