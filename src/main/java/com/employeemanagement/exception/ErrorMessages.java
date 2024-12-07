package com.employeemanagement.exception;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    HTTP_MESSAGE_NOT_READABLE("REQ0011","Message not redeable");
    private final String errorCode;
    private final String message ;
    ErrorMessages(String errorCode,String message){
        this.errorCode = errorCode;
        this.message =  message;
    }
}
