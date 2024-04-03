package com.microservice.crud.services;

import com.microservice.crud.models.UserModel;
import com.microservice.crud.repositories.IUserReposiotory;
import configuration.utils.General;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserReposiotory iUserReposiotory;

    public ArrayList<UserModel> getUserAll(){

//        List<UserModel> userList = new ArrayList<UserModel>();
//
//        userList = iUserReposiotory.findAll();

        return (ArrayList<UserModel>) iUserReposiotory.findAll();
    }

    public UserModel saveUser(UserModel userModel){

       userModel.builder(). General.encryptPassword(userModel);

        return iUserReposiotory.save(userModel);
    }

    public Optional<UserModel> getUserById(Long id){

        return iUserReposiotory.findById(id);
    }

    public UserModel updateUser(UserModel userModelRequest, Long id ){

        UserModel  user = iUserReposiotory.findById(id).get();
        /*user.setNames(userModelRequest.getNames());
        user.setFirtSurname(userModelRequest.getFirtSurname());
        user.setSecondSurname(userModelRequest.getSecondSurname());
        user.setCellPhoneNumber("0000000000");
        user.setAddress("0000000000");*/

        user.builder()
                .names(userModelRequest.getNames())
                .firtSurname(userModelRequest.getFirtSurname())
                .secondSurname(userModelRequest.getSecondSurname())
                .cellPhoneNumber("0000000000")
                .address("0000000000")
                .build();

        return user;

    }

    public String deleteUser(Long id){
        try {
             iUserReposiotory.deleteById(id);
              return "usuario borrado con exito";
        }catch (Exception e){
            return "usuario borrado con exito";

        }
    }



}
