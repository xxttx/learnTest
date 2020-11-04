package com.pactera.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pactera.springboot.mapper.OrderMapper;
import com.pactera.springboot.mapper.ProductMapper;
import com.pactera.springboot.model.Order;
import com.pactera.springboot.model.Product;
import com.pactera.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: Lance
 * @create: 2020-09-19
 **/
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public BaseMapper<Order> getMapper() {
        return orderMapper;
    }


    @Override
    public List<Order> findOrdersByMemberName(String memberName) {

        return orderMapper.selectList(new LambdaQueryWrapper<Order>().eq(Order::getMemberName, memberName));
    }
}
