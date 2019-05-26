package com.pk.ordersapp.spring.controller;

import com.pk.ordersapp.spring.model.Order;
import com.pk.ordersapp.spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

   @Autowired
   private OrderService orderService;

   /*---Add new order---*/
   @PostMapping("/order")
   public ResponseEntity<?> save(@RequestBody Order order) {
      long id = orderService.save(order);
      return ResponseEntity.ok().body("New Order has been saved with ID:" + id);
   }

   /*---Get a order by id---*/
   @GetMapping("/order/{id}")
   public ResponseEntity<Order> get(@PathVariable("id") long id) {
      Order order = orderService.get(id);
      return ResponseEntity.ok().body(order);
   }

   /*---get all orders---*/
   @CrossOrigin(origins = "http://localhost:8081")
   @GetMapping("/order")
   public ResponseEntity<List<Order>> list() {
      List<Order> orders = orderService.list();
      return ResponseEntity.ok().body(orders);
   }

   /*---Update a order by id---*/
   @PutMapping("/order/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Order order) {
      orderService.update(id, order);
      return ResponseEntity.ok().body("Order has been updated successfully.");
   }

   /*---Delete a order by id---*/
   @DeleteMapping("/order/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      orderService.delete(id);
      return ResponseEntity.ok().body("Order has been deleted successfully.");
   }
}