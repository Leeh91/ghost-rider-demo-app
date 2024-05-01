package br.com.demo.domains;

import br.com.demo.annotations.validation.IsCpfValid;
import br.com.demo.annotations.validation.IsValidEmail;
import br.com.demo.annotations.validation.IsValidString;
import br.com.demo.annotations.validation.Required;
import br.com.demo.utils.SelfValidating;

public class DriverAccount extends Account {

    private Car car;

    private DriverAccount(DriverAccountBuilder builder) {
        super(builder.id, builder.name, builder.email, builder.cpf);
        this.car = builder.car;
    }

    public Car getCar() {
        return car;
    }

    public static IdBuilder getBuilder() {
        return new DriverAccountBuilder();
    }

    private static final class DriverAccountBuilder extends SelfValidating<DriverAccount> implements IdBuilder, NameBuilder, EmailBuilder, CpfBuilder, CarBuilder, Builder {

        private Long id;
        @IsValidString(message = "Campo nome obrigatório")
        private String name;
        @IsValidEmail(message = "Campo email inválido")
        @IsValidString(message = "Campo email obrigatório")
        private String email;
        @IsCpfValid(message = "Campo cpf inválido")
        @IsValidString(message = "Campo cpf obrigatório")
        private String cpf;
        @Required(message = "Campo carro obrigatório")
        private Car car;

        @Override
        public NameBuilder id(Long id) {
            this.id = id;
            return this;
        }

        @Override
        public EmailBuilder name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public CpfBuilder email(String email) {
            this.email = email;
            return this;
        }

        @Override
        public CarBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder car(Car car) {
            this.car = car;
            return this;
        }

        @Override
        public DriverAccount build() {
            validateSelf();
            return new DriverAccount(this);
        }
    }

    public interface Builder {
        DriverAccount build();
    }

    public interface CarBuilder {
        Builder car(Car car);
    }

    public interface CpfBuilder {
        CarBuilder cpf(String cpf);
    }

    public interface EmailBuilder {
        CpfBuilder email(String email);
    }

    public interface NameBuilder {
        EmailBuilder name(String name);
    }

    public interface IdBuilder {
        NameBuilder id(Long id);
    }
}
