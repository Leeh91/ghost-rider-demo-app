package br.com.demo.controllers.signup.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignupRequestDTO {

    private String name;
    private String email;
    private String cpf;
    private boolean isDriver;
    private boolean isPassenger;
    private String carPlate;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public boolean isDriver() {
        return isDriver;
    }
    public void setDriver(boolean isDriver) {
        this.isDriver = isDriver;
    }
    public boolean isPassenger() {
        return isPassenger;
    }
    public void setPassenger(boolean isPassenger) {
        this.isPassenger = isPassenger;
    }
    public String getCarPlate() {
        return carPlate;
    }
    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }
}
