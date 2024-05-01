package br.com.demo.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;

public class RestAPIError {

    private final List<String> errorMessages;
    private final HttpStatus status;
    private final String description;

    public RestAPIError(HttpStatus status, String description, List<String> errorMessages) {
        this.status = status;
        this.description = description;
        this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
