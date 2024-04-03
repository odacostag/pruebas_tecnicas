package com.microservice.crud.controllers;

import com.microservice.crud.models.UserModel;
import com.microservice.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/crud")
public class CrudController {

    @Autowired
    UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUserAll(){
        return userService.getUserAll();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel userModel){
        return this.userService.saveUser(userModel);
    }

    @GetMapping(path="/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping(path="/{id}")
    public UserModel saveUser(@RequestBody UserModel userModel, Long id){
        return  userService.updateUser(userModel, id);
    }

    @DeleteMapping(path="/{id}")
    public String deleteById(@PathVariable Long id){
        return  userService.deleteUser(id);
    }






}
