package com.pk.ordersapp.spring.dao;

import com.pk.ordersapp.spring.model.Order;
import com.pk.ordersapp.spring.model.OrderLine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrdertDaoImp implements OrderDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Autowired
   private OrderLineDao orderLineDao;

   @Override
   public long save(Order order) {
      sessionFactory.getCurrentSession().save(order);
//      System.out.println(order.toString() + ' ' + order.getId());
//      for (OrderLine orderLine:order.getOrderLines()) {
//         System.out.println(orderLine.toString() + ' ' + orderLine.getCount());
//      }
      return order.getId();
   }

   @Override
   public Order get(long id) {
      return sessionFactory.getCurrentSession().get(Order.class, id);
   }

   @Override
   public List<Order> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Order> cq = cb.createQuery(Order.class);
      Root<Order> root = cq.from(Order.class);
      cq.select(root);
      Query<Order> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(long id, Order order) {
      Session session = sessionFactory.getCurrentSession();
      Order order2 = session.byId(Order.class).load(id);
      order2.setDestinationCity(order.getDestinationCity());
      order2.setDestinationPostCode(order.getDestinationPostCode());
      order2.setDestinationStreet(order.getDestinationStreet());
      for (OrderLine orderLine:order.getOrderLines()) {
         orderLineDao.update(orderLine.getId(),orderLine);
      }
      order2.setOrderLines(order.getOrderLines());

      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Order order = session.byId(Order.class).load(id);
      session.delete(order);
   }

}
