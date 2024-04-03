package com.microservice.inventory.repositories;

import com.microservice.inventory.models.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyReposiotory extends JpaRepository<CompanyModel, Long> {

    CompanyModel findByNit(String nit);


}
