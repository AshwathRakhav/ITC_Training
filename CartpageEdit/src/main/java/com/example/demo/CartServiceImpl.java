package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

@Service
public class CartServiceImpl implements CartService {

 

    @Autowired
    private CartRepository CartRepository;

 

    @Override
    public List<Cart> getAllCarts() {
        return CartRepository.findAll();
    }

 

    @Override
    public Optional<Cart> getCartById(Long id) {
        return CartRepository.findById(id);
    }

 

    @Override
    public Cart createCart(Cart Cart) {
        return CartRepository.save(Cart);
    }

 

    @Override
    public Cart updateCart(Long id, Cart updatedCart) {
        if (CartRepository.existsById(id)) {
            updatedCart.setId(id);
            return CartRepository.save(updatedCart);
        }
        return null;
    }

 

    @Override
    public void deleteCart(Long id) {
        CartRepository.deleteById(id);
    }
}