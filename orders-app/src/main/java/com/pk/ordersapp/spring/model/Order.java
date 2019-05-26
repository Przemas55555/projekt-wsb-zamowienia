package com.pk.ordersapp.spring.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destination_city;
    private String destination_post_code;
    private String destination_street;

    @OneToMany(mappedBy = "order", targetEntity = OrderLine.class)
    private List<OrderLine> orderLines;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinationCity() {
        return destination_city;
    }

    public void setDestinationCity(String destination_city) {
        this.destination_city = destination_city;
    }

    public String getDestinationPostCode() {
        return destination_post_code;
    }

    public void setDestinationPostCode(String destination_post_code) {
        this.destination_post_code = destination_post_code;
    }

    public String getDestinationStreet() {
        return destination_street;
    }

    public void setDestinationStreet(String destination_street) {
        this.destination_street = destination_street;
    }
}
