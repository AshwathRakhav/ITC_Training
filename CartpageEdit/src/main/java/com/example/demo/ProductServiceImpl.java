package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

@Service
public class ProductServiceImpl implements ProductService {

 

    @Autowired
    private ProductRepository productRepository;

 

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

 

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

}