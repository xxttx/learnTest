package com.pactera.springboot.service;

import com.pactera.springboot.model.Order;

import java.util.List;

public interface OrderService extends BaseService<Order> {
    public List<Order> findOrdersByMemberName(String memberName);

}
