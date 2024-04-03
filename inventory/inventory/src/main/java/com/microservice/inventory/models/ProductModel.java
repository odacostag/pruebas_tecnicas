package com.microservice.inventory.models;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name="productos")
@Builder
public class ProductModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String code;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    /*@ManyToOne
    private CompanyModel companyModel;*/

//    @ManyToOne
//    private CategoryModel categoryModel;

    public ProductModel(Long id, String code, String name, String description
//                        ,CompanyModel companyModel,                        CategoryModel categoryModel
                        ) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
//        this.companyModel = companyModel;
//        this.categoryModel = categoryModel;
    }

    public ProductModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public CompanyModel getCompanyModel() {
//        return companyModel;
//    }
//
//    public void setCompanyModel(CompanyModel companyModel) {
//        this.companyModel = companyModel;
//    }

//    public CategoryModel getCategoryModel() {
//        return categoryModel;
//    }
//
//    public void setCategoryModel(CategoryModel categoryModel) {
//        this.categoryModel = categoryModel;
//    }
}
