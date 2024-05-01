package br.com.demo.exceptions;

import jakarta.validation.ConstraintViolationException;

import java.util.Optional;

public class ValidationException extends RuntimeException {

    private ConstraintViolationException constraintViolationException;

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, ConstraintViolationException constraintViolationException) {
        super(message);
        this.constraintViolationException = constraintViolationException;
    }

    public Optional<ConstraintViolationException> getConstraintExceptions() {
        return Optional.ofNullable(constraintViolationException);
    }
}
