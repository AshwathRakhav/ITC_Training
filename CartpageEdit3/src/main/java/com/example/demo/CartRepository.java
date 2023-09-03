package com.example.demo;

 

 

import org.springframework.data.jpa.repository.JpaRepository;

 

public interface CartRepository extends JpaRepository<Cart, Long> {
    // You can add custom query methods here if needed
}