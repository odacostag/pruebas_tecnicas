package com.microservice.inventory.repositories;

import com.microservice.inventory.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductReposiotory extends JpaRepository<ProductModel, Long> {

//    @Query("SELECT u FROM UserModel u WHERE u.email = ?1 AND u.apellido = ?2")
//    List<UserModel> findByNombreAndApellido(String nombre, String apellido);





}
