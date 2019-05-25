package com.pk.ordersapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Product")
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private Integer priceNett;
   private Integer priceGross;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getPriceNett() {
      return priceNett;
   }

   public void setPriceNett(Integer priceNett) {
      this.priceNett = priceNett;
   }

   public Integer getPriceGross() {
      return priceGross;
   }

   public void setPriceGross(Integer priceGross) {
      this.priceGross = priceGross;
   }
}
