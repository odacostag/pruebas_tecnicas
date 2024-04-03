package com.microservice.inventory.models;


import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name="categoria")
@Builder
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String name;

    public CategoryModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
