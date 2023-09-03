
package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

 

@RestController

@RequestMapping("/cart")

public class CartController {

 

    @Autowired

    private CartService CartService;

 

    @GetMapping("/all")

    public ResponseEntity<List<Cart>> getAllCarts() {

        List<Cart> Carts = CartService.getAllCarts();

        return new ResponseEntity<>(Carts, HttpStatus.OK);

    }

    @GetMapping("/{id}")

    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {

        Optional<Cart> Cart = CartService.getCartById(id);

        return Cart.map(value -> new ResponseEntity<>(value, HttpStatus.OK))

                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    
    @Autowired
    private ProductRepository ProductRepository;
    
    @PostMapping
    
    

    public ResponseEntity<Cart> createCart(@RequestBody Cart CartEntity) {
    	List<Product> ProductData = ProductRepository.findAll();
        List<Cart> CartEntities = new ArrayList<>();
        
        for (Product ProductEntity : ProductData) 
        {
            if(CartEntity.getProd_id() == ProductEntity.getId())
            {
            	CartEntity.setProd_id(ProductEntity.getId());
            	CartEntity.setName(ProductEntity.getName());
                CartEntity.setCategory(ProductEntity.getCatogory());
                ProductEntity.setQuantity(ProductEntity.getQuantity()-CartEntity.getQuantity());
                CartEntity.setPrice(ProductEntity.getDiscount());
                var sum = ProductEntity.getDiscount()*CartEntity.getQuantity();
                CartEntity.setTotal(sum);
                CartEntities.add(CartEntity);
                ProductEntity.setId(ProductEntity.getId());
                ProductRepository.save(ProductEntity);
                break;
            }
            
        }
        //CartRepository.saveAll(CartEntities);

        Cart createdCart = CartService.createCart(CartEntity);

        return new ResponseEntity<>(createdCart, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")

    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart updatedCart) {

        Cart Cart = CartService.updateCart(id, updatedCart);

        if (Cart != null) {

            return new ResponseEntity<>(Cart, HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {

        CartService.deleteCart(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
