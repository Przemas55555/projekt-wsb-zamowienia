package com.pk.ordersapp.spring.service;

import com.pk.ordersapp.spring.dao.OrderDao;
import com.pk.ordersapp.spring.model.Order;
import com.pk.ordersapp.spring.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderServiceImp implements OrderService {

   @Autowired
   private OrderDao orderDao;

   @Transactional
   @Override
   public long save(Order order) {
      for(OrderLine orderLine: order.getOrderLines()) {
         orderLine.setOrder(order);
      }
      return orderDao.save(order);
   }

   @Override
   public Order get(long id) {
      return orderDao.get(id);
   }

   @Override
   public List<Order> list() {
      return orderDao.list();
   }

   @Transactional
   @Override
   public void update(long id, Order order) {
      orderDao.update(id, order);
   }

   @Transactional
   @Override
   public void delete(long id) {
      orderDao.delete(id);
   }

}
