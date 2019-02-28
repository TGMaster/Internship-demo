/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.repository;

import com.spring.boot.model.entity.User;
import javax.transaction.Transactional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Quy Duong
 */
@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    
}
