package com.microservice.inventory.services;

import com.microservice.inventory.configuration.JsonResponse;
import com.microservice.inventory.configuration.utils.General;
import com.microservice.inventory.models.UserModel;
import com.microservice.inventory.repositories.IUserReposiotory;
import com.microservice.inventory.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import static com.microservice.inventory.configuration.Constant.*;

@Service
public class UserService {

    @Autowired
    IUserReposiotory iUserReposiotory;

    public ArrayList<UserModel> getUserAll(){

        return (ArrayList<UserModel>) iUserReposiotory.findAll();
    }

    public JsonResponse saveUser(UserModel userModel) {
        try {
            JsonResponse response;
            UserModel user = iUserReposiotory.findByEmail(userModel.getEmail());

            if(user!=null) {
                response = new JsonResponse(205, EMAIL_ALREADY_REGISTERED, null);
                return response;

            }

            String password = General.encryptPassword(userModel.getPassword());
            response = new JsonResponse(200, SUCCESS, null);
            iUserReposiotory.save(UserModel.builder().password(password).email(userModel.getEmail()).build());

            return response;

        } catch (Exception e) {
            return new JsonResponse(404, MISTAKE, null);
        }

    }

    public Optional<UserModel> getUserById(Long id){

        return iUserReposiotory.findById(id);
    }

    public JsonResponse validateUser(String email, String password){

       UserModel user = iUserReposiotory.findByEmail(email);
        JsonResponse response;

        if(user==null) {
            response = new JsonResponse(202, USER_NOT_FOUND, null);
            return response;
        }

        if(!user.getPassword().equals(General.encryptPassword(password))){
            response = new JsonResponse(204, PASSWORD_DOES_NOT_MATCH, null);
            return response;
        }

        UserResponse responseBody = new UserResponse(user.getEmail(), HIDE_PASSWORD, user.getRole());
        response = new JsonResponse(200, SUCCESS, responseBody);

        return response;
    }

    public UserModel updateUser(UserModel userModelRequest, Long id ){

        UserModel  user = iUserReposiotory.findById(id).get();
        /*user.setNames(userModelRequest.getNames());
        user.setFirtSurname(userModelRequest.getFirtSurname());
        user.setSecondSurname(userModelRequest.getSecondSurname());
        user.setCellPhoneNumber("0000000000");
        user.setAddress("0000000000");*/

        user.builder()
//                .names(userModelRequest.getNames())
//                .firtSurname(userModelRequest.getFirtSurname())
//                .secondSurname(userModelRequest.getSecondSurname())
//                .cellPhoneNumber("0000000000")
//                .address("0000000000")
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
