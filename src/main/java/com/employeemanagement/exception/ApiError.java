package com.employeemanagement.exception;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class ApiError {
    private String errorCode;
    private String errorMessage;

    public ApiError(ErrorMessages errorMessages) {
        this.errorCode = errorMessages.getErrorCode();
        this.errorMessage = errorMessages.getMessage();
    }
}
