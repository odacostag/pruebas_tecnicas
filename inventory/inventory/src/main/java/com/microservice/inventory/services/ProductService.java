package com.microservice.inventory.services;

import com.microservice.inventory.configuration.JsonResponse;
import com.microservice.inventory.models.CompanyModel;
import com.microservice.inventory.models.ProductModel;
import com.microservice.inventory.repositories.IProductReposiotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.microservice.inventory.configuration.Constant.MISTAKE;
import static com.microservice.inventory.configuration.Constant.SUCCESS;

@Service
public class ProductService {

    @Autowired
    IProductReposiotory iProductReposiotory;

    public ArrayList<ProductModel> getProductAll(){

        return (ArrayList<ProductModel>) iProductReposiotory.findAll();
    }

    public JsonResponse saveProduct(ProductModel productModel) {
        try {
            JsonResponse response;
//            ProductModel company = iCompanyReposiotory.findByNit(ProductModel.getNit());
//
//            if(company!=null) {
//                response = new JsonResponse(205, COMPANY_ALREADY_REGISTERED, null);
//                return response;
//
//            }

            response = new JsonResponse(200, SUCCESS, null);
            iProductReposiotory.save(productModel);

            return response;

        } catch (Exception e) {
            return new JsonResponse(404, MISTAKE, null);
        }

    }


    public ProductModel productModel (ProductModel productModel){

        return  ProductModel.builder()
                .name(productModel.getName())
                .code(productModel.getCode())
                .description(productModel.getDescription())
//                .companyModel(CompanyModel.builder().nit(productModel.getCompanyModel().getNit()).build())
                .build();

    }
}
