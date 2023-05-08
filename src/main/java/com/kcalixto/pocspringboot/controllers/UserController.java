package com.kcalixto.pocspringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kcalixto.pocspringboot.entities.User;
import com.kcalixto.pocspringboot.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id can't be null");
        }

        User user = repository.findById(id).get();
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        return user;
    }

    @PostMapping
    public User save(@RequestBody User user) {
        if (user == null) {
            throw new IllegalArgumentException("User can't be null");
        }

        User result = repository.save(user);
        return result;
    }
}
