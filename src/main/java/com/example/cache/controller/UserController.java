package com.example.cache.controller;

import com.example.cache.domain.User;
import com.example.cache.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type User controller.
 */
@RestController
public class UserController {

    /**
     * User service.
     */
    @Autowired
    private IUserService userService;


    /**
     * Create user.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping
    public User create(@RequestBody User user){
        return this.userService.create(user);
    }

    /**
     * Update user.
     *
     * @param user the user
     * @return the user
     */
    @PutMapping
    public User update(@RequestBody User user){
        return this.userService.update(user);
    }

    /**
     * Find by id user.
     *
     * @param cpf the cpf
     * @return the user
     */
    @GetMapping(value="/{cpf}")
    public User findById(@PathVariable("cpf") String cpf){
        return this.userService.findById(cpf);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping
    public List<User> findAll(){
        return this.userService.findAll();
    }

    /**
     * Delete.
     *
     * @param cpf the cpf
     */
    @DeleteMapping(value="/{cpf}")
    public void delete(@PathVariable("cpf") String cpf){
        this.userService.delete(cpf);
    }
}

