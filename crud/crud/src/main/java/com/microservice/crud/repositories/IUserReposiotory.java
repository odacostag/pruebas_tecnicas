package com.microservice.crud.repositories;

import com.microservice.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserReposiotory extends JpaRepository<UserModel, Long> {


}
