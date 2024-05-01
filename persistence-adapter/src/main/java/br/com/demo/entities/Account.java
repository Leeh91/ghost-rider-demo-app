package br.com.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "is_driver", nullable = false)
    private boolean isDriver;

    @Column(name = "is_passenger", nullable = false)
    private boolean isPassenger;

    @Column(name = "car_plate")
    private String carPlate;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDriver(boolean driver) {
        isDriver = driver;
    }

    public void setPassenger(boolean passenger) {
        isPassenger = passenger;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isDriver() {
        return isDriver;
    }

    public boolean isPassenger() {
        return isPassenger;
    }

    public String getCarPlate() {
        return carPlate;
    }

}
