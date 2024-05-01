package br.com.demo.utils;

import br.com.demo.exceptions.ValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

/**
 * Efetua a auto-validação da classe que a estende pela chamada do método validateSelf.
 * @param <T> Passar a própria classe de implementação como template como template
 */
public abstract class SelfValidating<T> {
    private final Validator validator;

    public SelfValidating() {
        ValidatorFactory factory = buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Evaluates all Bean Validations on the attributes of this
     * instance.
     */
    protected void validateSelf() {
        @SuppressWarnings("unchecked")
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ValidationException(
                    "Erro na validação dos dados",
                    new ConstraintViolationException(violations));
        }
    }
}
