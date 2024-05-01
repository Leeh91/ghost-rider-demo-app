package br.com.demo.domains;

import br.com.demo.annotations.validation.IsValidString;
import br.com.demo.utils.SelfValidating;

public class Car {

    private final String carPlate;

    private Car(Builder builder) {
        this.carPlate = builder.carPlate;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder extends SelfValidating<Builder> {
        @IsValidString(message = "Placa do carro é inválida")
        private String carPlate;
        public Builder carPlate(String carPlate) {
            this.carPlate = carPlate;
            return this;
        }
        public Car build() {
            validateSelf();
            return new Car(this);
        }
    }
}
