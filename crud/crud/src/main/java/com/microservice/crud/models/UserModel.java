package com.microservice.crud.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="usuario_dos")
@Builder
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUser;

    @Column(name = "nombres")
    private String names;

    @Column(name = "primer_apellido")
    private String firtSurname;

    @Column(name = "segundo_apellido")
    private String secondSurname;

    @Column(name = "numero_celular")
    private String cellPhoneNumber;

    @Column(name = "fecha_nacimiento")
    private Date birthdayDate;

    @Column(name = "direccion")
    private String address;

    @Column(name = "email")
    private String email;

    public UserModel(Integer idUser, String names, String firtSurname, String secondSurname, String cellPhoneNumber, Date birthdayDate, String address, String email) {
        this.idUser = idUser;
        this.names = names;
        this.firtSurname = firtSurname;
        this.secondSurname = secondSurname;
        this.cellPhoneNumber = cellPhoneNumber;
        this.birthdayDate = birthdayDate;
        this.address = address;
        this.email = email;
    }

    public UserModel() {
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getFirtSurname() {
        return firtSurname;
    }

    public void setFirtSurname(String firtSurname) {
        this.firtSurname = firtSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
