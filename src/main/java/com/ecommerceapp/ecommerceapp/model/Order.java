package com.ecommerceapp.ecommerceapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "orders")
public class Order {
    @Id
   private String  id;
    private String title;
    private String description;
    private String imgSrc;
    private double quantity;
    private double price;

    public void setStatus(String orderPlaced) {
    }



}

