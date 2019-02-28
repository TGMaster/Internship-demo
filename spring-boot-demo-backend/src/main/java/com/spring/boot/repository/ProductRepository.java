/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.repository;

import com.spring.boot.model.entity.Product;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author S410U
 */
@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Long>{
    
}
