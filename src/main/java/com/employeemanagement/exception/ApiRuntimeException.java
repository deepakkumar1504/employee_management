package com.employeemanagement.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class ApiRuntimeException extends RuntimeException {
    private HttpStatus status;
    private List<ApiError> errors;
    private Object data;

    public ApiRuntimeException(HttpStatus status, List<ApiError> errors, Object data) {
        this.status = status;
        this.errors = errors;
        this.data = data;
    }

    public ApiRuntimeException(HttpStatus status, List<ApiError> errors) {
        this.status = status;
        this.errors = errors;
        this.data = data;
    }

    public ApiRuntimeException(HttpStatus status, Object data) {
        this.status = status;
        this.errors = errors;
        this.data = data;
    }

    public static ApiRuntimeException unauthorized(ApiError error) {
        return new ApiRuntimeException(HttpStatus.UNAUTHORIZED, Collections.singleton(error));
    }

    public static ApiRuntimeException unauthorized(List<ApiError> errors) {
        return new ApiRuntimeException(HttpStatus.UNAUTHORIZED, errors);
    }

    public static ApiRuntimeException badRequest(ErrorMessages errorMessages) {
        return new ApiRuntimeException(HttpStatus.BAD_REQUEST, Collections.singletonList(new ApiError(errorMessages)));
    }

    public static ApiRuntimeException badRequest(ApiError error) {
        return new ApiRuntimeException(HttpStatus.BAD_REQUEST, Collections.singletonList(error));

    }

    public static ApiRuntimeException conflict(ApiError error) {
        return new ApiRuntimeException(HttpStatus.CONFLICT, Collections.singletonList(error));

    }

    public static ApiRuntimeException notFound(ApiError error) {
        return new ApiRuntimeException(HttpStatus.NOT_FOUND, Collections.singletonList(error));

    }

    public static ApiRuntimeException preConditionFailed(ApiError error) {
        return new ApiRuntimeException(HttpStatus.PRECONDITION_FAILED, Collections.singletonList(error));

    }

    public static ApiRuntimeException internalServerError(ApiError error) {
        return new ApiRuntimeException(HttpStatus.INTERNAL_SERVER_ERROR, Collections.singletonList(error));

    }

}
