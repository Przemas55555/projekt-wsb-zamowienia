package com.pk.ordersapp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pk.ordersapp.spring.dao.ProductDao;
import com.pk.ordersapp.spring.model.Product;

@Service
@Transactional(readOnly = true)
public class ProductServiceImp implements ProductService {

   @Autowired
   private ProductDao productDao;

   @Transactional
   @Override
   public long save(Product product) {
      return productDao.save(product);
   }

   @Override
   public Product get(long id) {
      return productDao.get(id);
   }

   @Override
   public List<Product> list() {
      return productDao.list();
   }

   @Transactional
   @Override
   public void update(long id, Product product) {
      productDao.update(id, product);
   }

   @Transactional
   @Override
   public void delete(long id) {
      productDao.delete(id);
   }

}
