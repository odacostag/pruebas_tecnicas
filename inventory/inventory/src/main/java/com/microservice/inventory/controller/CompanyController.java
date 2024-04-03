package com.microservice.inventory.controller;


import com.microservice.inventory.configuration.JsonResponse;
import com.microservice.inventory.models.CompanyModel;
import com.microservice.inventory.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/company")
public class CompanyController {


    @Autowired
    CompanyService companyService;


    @GetMapping
    public ArrayList<CompanyModel> getCompanyAll(){
        return companyService.getCompanyAll();
    }

    @PostMapping
    public JsonResponse saveCompany(@RequestBody CompanyModel companyModel){
        return this.companyService.saveCompany(companyModel);
    }







}
