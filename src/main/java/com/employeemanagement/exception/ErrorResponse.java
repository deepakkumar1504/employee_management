package com.employeemanagement.exception;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    private List<ApiError> errors;
    private String details;
    private LocalDateTime timestamp;

    public ErrorResponse(List<ApiError> errors) {
        this.errors = errors;
    }

    public ErrorResponse(List<ApiError> errors, Object data) {
        this.errors = errors;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

}