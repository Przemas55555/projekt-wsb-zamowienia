package com.pk.ordersapp.spring.dao;

import com.pk.ordersapp.spring.model.OrderLine;

import java.util.List;

public interface OrderLineDao {
    long save(OrderLine orderLine);

    OrderLine get(long id);

    List<OrderLine> list();

    void update(long id, OrderLine orderLine);

    void delete(long id);
}
