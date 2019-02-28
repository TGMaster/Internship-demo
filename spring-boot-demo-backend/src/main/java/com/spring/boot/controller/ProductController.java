/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.controller;

import com.spring.boot.model.entity.Product;
import com.spring.boot.service.ProductService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author S410U
 */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public List<Product> getAllProduct(
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        return productService.getAllProducts();
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @RequestMapping(path = "/product/{id}", method = RequestMethod.GET)
    public Product getProduct(
            HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable Long id
    ) {
        return productService.getProduct(id);
    }

    @RequestMapping(path = "/product", method = RequestMethod.PUT)
    public Product updateProduct(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody Product product
    ) {
        Product existedProduct = productService.getProduct(product.getId());
        if (existedProduct != null) {
            for (Product p : productService.getAllProducts()) {
                if (p.getId() == product.getId())
                    existedProduct = product;
            }
        }
        return productService.addProduct(existedProduct);
    }

    @RequestMapping(path = "/product/{id}", method = RequestMethod.DELETE)
    public String demoDeleteUser(@PathVariable Long id) {
        Product existedProduct = productService.getProduct(id);
        if (existedProduct != null) {
            productService.deleteProduct(existedProduct);
            return "Successful";
        }
        return "Not found user";
    }
}
