package com.ecommerceapp.ecommerceapp.controller;

import com.ecommerceapp.ecommerceapp.model.User;
import com.ecommerceapp.ecommerceapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private UserService userService;


    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<User> register(@RequestBody User user) {
        // Assuming UserService has a method to save user data
        User newUser = userService.save(user);
        return ResponseEntity.ok(newUser);
    }

}

