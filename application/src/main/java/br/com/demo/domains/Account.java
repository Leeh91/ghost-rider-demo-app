package br.com.demo.domains;

import java.util.Optional;

public class Account {

    protected Long id;
    protected String name;
    protected String email;
    protected String cpf;

    protected Account(Long id, String name, String email, String cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(id);
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
}
