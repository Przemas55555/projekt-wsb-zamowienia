package com.pk.ordersapp.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.pk.ordersapp.spring.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImp implements ProductDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Product product) {
      sessionFactory.getCurrentSession().save(product);
      return product.getId();
   }

   @Override
   public Product get(long id) {
      return sessionFactory.getCurrentSession().get(Product.class, id);
   }

   @Override
   public List<Product> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Product> cq = cb.createQuery(Product.class);
      Root<Product> root = cq.from(Product.class);
      cq.select(root);
      Query<Product> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(long id, Product product) {
      Session session = sessionFactory.getCurrentSession();
      Product product2 = session.byId(Product.class).load(id);
      product2.setName(product.getName());
      product2.setPriceGross(product.getPriceNett());
      product2.setPriceGross(product.getPriceGross());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Product product = session.byId(Product.class).load(id);
      session.delete(product);
   }

}
