package com.microservice.inventory.services;

import com.microservice.inventory.configuration.JsonResponse;
import com.microservice.inventory.models.CompanyModel;
import com.microservice.inventory.repositories.ICompanyReposiotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.microservice.inventory.configuration.Constant.*;

@Service
public class CompanyService {

    @Autowired
    ICompanyReposiotory iCompanyReposiotory;

    public ArrayList<CompanyModel> getCompanyAll(){

        return (ArrayList<CompanyModel>) iCompanyReposiotory.findAll();
    }

    public JsonResponse saveCompany(CompanyModel companyModel) {
        try {
            JsonResponse response;
            CompanyModel company = iCompanyReposiotory.findByNit(companyModel.getNit());

            if(company!=null) {
                response = new JsonResponse(205, COMPANY_ALREADY_REGISTERED, null);
                return response;

            }

            response = new JsonResponse(200, SUCCESS, null);
            iCompanyReposiotory.save(companyModel);

            return response;

        } catch (Exception e) {
            return new JsonResponse(404, MISTAKE, null);
        }

    }


    public CompanyModel companyModel (CompanyModel companyModel){

        return  CompanyModel.builder()
                .phone(companyModel.getPhone())
                .name(companyModel.getName())
                .nit(companyModel.getNit())
                .address(companyModel.getAddress())
                .build();

    }
}
