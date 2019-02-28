/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.service;

import com.spring.boot.model.entity.Product;
import com.spring.boot.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author S410U
 */
@Component
public class ProductService {
        
    @Autowired
    ProductRepository productRepository;
    
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }
    
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
    
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }
}
