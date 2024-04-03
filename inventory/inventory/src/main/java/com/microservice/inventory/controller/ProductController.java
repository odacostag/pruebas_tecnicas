package com.microservice.inventory.controller;


import com.microservice.inventory.configuration.JsonResponse;
import com.microservice.inventory.models.ProductModel;
import com.microservice.inventory.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping
    public ArrayList<ProductModel> getProductAll(){
        return productService.getProductAll();
    }



    @PostMapping
    public JsonResponse saveUser(@RequestBody ProductModel productModel){
        return this.productService.saveProduct(productModel);
    }










}
