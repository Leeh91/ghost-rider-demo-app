package br.com.demo.ports.in.dtos;

public class AccountCriteriaDTO {

    private String name;
    private String email;
    private String cpf;
    private AccountType accountType;
    private String carPlate;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
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

    public AccountType getAccountType() {
        return accountType;
    }

    public String getCarPlate() {
        return carPlate;
    }
}
