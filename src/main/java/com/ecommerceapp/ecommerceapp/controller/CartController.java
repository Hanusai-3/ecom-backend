package com.ecommerceapp.ecommerceapp.controller;

import com.ecommerceapp.ecommerceapp.model.Cart;
import com.ecommerceapp.ecommerceapp.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*") // Adjust frontend URL
public class CartController {
    @Autowired
    private CartRepository cartRepository;
    @CrossOrigin(origins = "*")
    @PostMapping()
    public Cart addToCart(@RequestBody Cart cart) {
        return cartRepository.save(cart);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/list")
    public List<Cart> getCartItems() {
        return cartRepository.findAll();
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        Optional<Cart> cartOptional = cartRepository.findById(id);

        if (cartOptional.isPresent()) {
            cartRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}








