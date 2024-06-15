package com.ecommerceapp.ecommerceapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class CartItem {

    @Id
    private String id;
    private String productId;
    private String title;
    private String description;
    private String imgSrc;
    private double price;
    private int quantity;

    // Getters and setters


}
