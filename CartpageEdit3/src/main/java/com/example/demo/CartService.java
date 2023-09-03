package com.example.demo;

import java.util.List;
import java.util.Optional;

 

public interface CartService {

 

    List<Cart> getAllCarts();
    Optional<Cart> getCartById(Long id);
    Cart createCart(Cart CartEntity);
    Cart updateCart(Long id, Cart updatedCart);
    void deleteCart(Long id);
}