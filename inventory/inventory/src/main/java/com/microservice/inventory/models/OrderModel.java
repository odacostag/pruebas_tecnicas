package com.microservice.inventory.models;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name="orden")
@Builder
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public OrderModel(Long id) {
        this.id = id;
    }

    public OrderModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
