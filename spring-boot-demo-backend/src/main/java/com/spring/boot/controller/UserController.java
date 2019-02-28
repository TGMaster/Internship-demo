/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.controller;

import com.spring.boot.model.entity.User;
import com.spring.boot.service.UserService;
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
 * @author Quy Duong
 */
@RestController
public class UserController {
    @Autowired
    UserService demoService;
    
    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<User> demoGetAllUser (
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        
        return demoService.getAllUsers();
    }
    
    @RequestMapping(value="/user",method = RequestMethod.POST, headers = "Accept=application/json")
    public User demoCreateUser (@RequestBody User user) {
        return demoService.saveUser(user);
    }
    
    @RequestMapping(path = "/user/{id}",method = RequestMethod.GET)
    public User demoGetUser (
            HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable Long id
    ) {
        return demoService.getUser(id);
    }
    
    @RequestMapping(path = "/user/{id}",method = RequestMethod.PUT)
    public User demoUpdateUser (
            HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable Long id
    ) {
        User existedUser = demoService.getUser(id);
        if (existedUser != null){
            existedUser.setName(existedUser.getName() + " Update");
        }
        return demoService.saveUser(existedUser);
    }
    
    @RequestMapping(path = "/user/{id}",method = RequestMethod.DELETE)
    public String demoDeleteUser(@PathVariable Long id) {
        User existedUser = demoService.getUser(id);
        if (existedUser != null){
            demoService.deleteUser(existedUser);
            return "Successful";
        }
        return "Not found user";
    }
}
