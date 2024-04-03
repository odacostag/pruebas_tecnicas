package com.microservice.inventory.controller;


import com.microservice.inventory.configuration.JsonResponse;
import com.microservice.inventory.models.UserModel;
import com.microservice.inventory.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    UserService userService;


    @GetMapping
    public ArrayList<UserModel> getUserAll(){
        return userService.getUserAll();
    }

    @PostMapping
    public JsonResponse saveUser(@RequestBody UserModel userModel){
        return this.userService.saveUser(userModel);
    }

    @GetMapping(path="/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping(path="/{email}/{password}")
    public JsonResponse validateUser(@PathVariable String email, @PathVariable String password){
        return userService.validateUser(email, password);
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
