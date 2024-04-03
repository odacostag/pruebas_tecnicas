package com.microservice.inventory.models;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name="precios")
@Builder
public class PricesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "valor")
    private double price;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductModel productModel;

    @ManyToOne
    @JoinColumn(name = "id_moneda")
    private MoneyModel moneyModeloneyModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public MoneyModel getMoneyModeloneyModel() {
        return moneyModeloneyModel;
    }

    public void setMoneyModeloneyModel(MoneyModel moneyModeloneyModel) {
        this.moneyModeloneyModel = moneyModeloneyModel;
    }
}
