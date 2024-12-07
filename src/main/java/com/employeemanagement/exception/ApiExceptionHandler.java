package com.employeemanagement.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiRuntimeException.class)
    public ResponseEntity<ErrorResponse> handlapiRuntimeException(ApiRuntimeException ex) {
        logger.error("HttpMesageReadable Exception occured", ex);

        ErrorResponse errorResponse ;
        if(Objects.nonNull(ex.getData())){
            errorResponse = new ErrorResponse(ex.getErrors(), ex.getData());
        }
        else{
            errorResponse = new ErrorResponse(ex.getErrors());
        }
        return new ResponseEntity<>(errorResponse,new HttpHeaders(), ex.getStatus());
    }
/*
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(UnauthorizedException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> handleConflictException(ConflictException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    // Handle other exceptions
    @ExceptionHandler(ApiRuntimeException.class)
    public ResponseEntity<ErrorResponse> handleApiRuntimeException(ApiRuntimeException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getErrorCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
