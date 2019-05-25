package com.pk.ordersapp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pk.ordersapp.spring.dao.BookDao;
import com.pk.ordersapp.spring.model.Product;

@Service
@Transactional(readOnly = true)
public class BookServiceImp implements BookService {

   @Autowired
   private BookDao bookDao;

   @Transactional
   @Override
   public long save(Product product) {
      return bookDao.save(product);
   }

   @Override
   public Product get(long id) {
      return bookDao.get(id);
   }

   @Override
   public List<Product> list() {
      return bookDao.list();
   }

   @Transactional
   @Override
   public void update(long id, Product product) {
      bookDao.update(id, product);
   }

   @Transactional
   @Override
   public void delete(long id) {
      bookDao.delete(id);
   }

}
