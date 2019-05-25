package com.pk.ordersapp.spring.controller;

import java.util.List;

import com.pk.ordersapp.spring.model.Product;
import com.pk.ordersapp.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

   @Autowired
   private ProductService productService;

   /*---Add new product---*/
//   @PostMapping("/product")
//   public ResponseEntity<?> save(@RequestBody Product product) {
//      long id = productService.save(product);
//      return ResponseEntity.ok().body("New Product has been saved with ID:" + id);
//   }

   /*---Get a product by id---*/
   @GetMapping("/product/{id}")
   public ResponseEntity<Product> get(@PathVariable("id") long id) {
      Product product = productService.get(id);
      return ResponseEntity.ok().body(product);
   }

   /*---get all products---*/
   @CrossOrigin(origins = "http://localhost:8081")
   @GetMapping("/product")
   public ResponseEntity<List<Product>> list() {
      List<Product> products = productService.list();
      return ResponseEntity.ok().body(products);
   }

   /*---Update a product by id---*/
   @PutMapping("/product/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Product product) {
      productService.update(id, product);
      return ResponseEntity.ok().body("Product has been updated successfully.");
   }

   /*---Delete a product by id---*/
   @DeleteMapping("/product/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      productService.delete(id);
      return ResponseEntity.ok().body("Product has been deleted successfully.");
   }
}