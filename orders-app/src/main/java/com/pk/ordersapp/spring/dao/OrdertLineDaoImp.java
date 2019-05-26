package com.pk.ordersapp.spring.dao;

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
public class OrdertLineDaoImp implements OrderLineDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(OrderLine orderLine) {
      sessionFactory.getCurrentSession().save(orderLine);
      return orderLine.getId();
   }

   @Override
   public OrderLine get(long id) {
      return sessionFactory.getCurrentSession().get(OrderLine.class, id);
   }

   @Override
   public List<OrderLine> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<OrderLine> cq = cb.createQuery(OrderLine.class);
      Root<OrderLine> root = cq.from(OrderLine.class);
      cq.select(root);
      Query<OrderLine> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(long id, OrderLine orderLine) {
      Session session = sessionFactory.getCurrentSession();
      OrderLine orderLine2 = session.byId(OrderLine.class).load(id);
      orderLine2.setProduct(orderLine.getProduct());
      orderLine2.setOrder(orderLine.getOrder());
      orderLine2.setCount(orderLine.getCount());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      OrderLine orderLine = session.byId(OrderLine.class).load(id);
      session.delete(orderLine);
   }

}
