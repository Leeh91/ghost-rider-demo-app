package br.com.demo.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<Object> handleBusinessExceptions(ValidationException ex) {
        List<String> errorMessages = ex.getConstraintExceptions()
                .map(ConstraintViolationException::getConstraintViolations)
                .map(violations -> violations.stream()
                        .map(ConstraintViolation::getMessage)
                        .collect(Collectors.toList()))
                .orElse(new ArrayList<>());

        RestAPIError error = new RestAPIError(HttpStatus.BAD_REQUEST, ex.getMessage(), errorMessages);
        return new ResponseEntity<>(error, error.getStatus());
    }
}
