package br.com.demo.domains;

import br.com.demo.annotations.validation.IsCpfValid;
import br.com.demo.annotations.validation.IsValidEmail;
import br.com.demo.annotations.validation.IsValidString;
import br.com.demo.utils.SelfValidating;

public class PassengerAccount extends Account {

    private PassengerAccount(PassengerAccountBuilder builder) {
        super(builder.id, builder.name, builder.email, builder.cpf);
    }

    public static IdBuilder getBuilder() {
        return new PassengerAccountBuilder();
    }

    private static final class PassengerAccountBuilder extends SelfValidating<PassengerAccount> implements IdBuilder, NameBuilder, EmailBuilder, CpfBuilder, Builder {

        private Long id;
        @IsValidString(message = "Campo nome obrigatório")
        private String name;
        @IsValidEmail(message = "Campo email inválido")
        @IsValidString(message = "Campo email obrigatório")
        private String email;
        @IsCpfValid(message = "Campo cpf inválido")
        @IsValidString(message = "Campo cpf obrigatório")
        private String cpf;


        @Override
        public PassengerAccount build() {
            validateSelf();
            return new PassengerAccount(this);
        }

        @Override
        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        @Override
        public CpfBuilder email(String email) {
           this.email = email;
           return this;
        }

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
    }

    public interface Builder {
        PassengerAccount build();
    }

    public interface CpfBuilder {
        Builder cpf(String cpf);
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
