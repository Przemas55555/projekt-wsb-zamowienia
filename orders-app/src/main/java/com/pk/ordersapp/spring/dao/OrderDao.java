package com.pk.ordersapp.spring.dao;

import com.pk.ordersapp.spring.model.Order;

import java.util.List;

public interface OrderDao {
    long save(Order order);

    Order get(long id);

    List<Order> list();

    void update(long id, Order order);

    void delete(long id);
}
