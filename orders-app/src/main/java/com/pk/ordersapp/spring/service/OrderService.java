package com.pk.ordersapp.spring.service;

import com.pk.ordersapp.spring.model.Order;
import com.pk.ordersapp.spring.model.Product;

import java.util.List;

public interface OrderService {

   long save(Order order);
   Order get(long id);
   List<Order> list();
   void update(long id, Order order);
   void delete(long id);
}
