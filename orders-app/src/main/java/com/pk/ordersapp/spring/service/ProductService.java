package com.pk.ordersapp.spring.service;

import java.util.List;

import com.pk.ordersapp.spring.model.Product;

public interface ProductService {

   long save(Product product);
   Product get(long id);
   List<Product> list();
   void update(long id, Product product);
   void delete(long id);
}
