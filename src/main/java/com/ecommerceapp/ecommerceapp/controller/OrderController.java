package com.ecommerceapp.ecommerceapp.controller;

import com.ecommerceapp.ecommerceapp.model.Order;
import com.ecommerceapp.ecommerceapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @CrossOrigin(origins = "*")
    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        order.setStatus("Order Placed");
        return orderRepository.save(order);
    }
    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        System.out.println("id"+ id+ orderRepository.existsById(id));
        Optional<Order> o = orderRepository.findById(id);

        System.out.println(o.isPresent());
        if (orderRepository.existsById(String.valueOf(id))) {
            orderRepository.deleteById(String.valueOf(id));
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
