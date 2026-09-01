package com.ateeburrahaman.spring_boot_crud_rest_api.dto.responseDto;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptionResponseDto {
    private int statusCode;
    private String error;
    private String path;
    private String message;
    private LocalDateTime timestamp;
    private Map<String,String> fieldErrors;

    public ValidationExceptionResponseDto(int statusCode
                                            , String error
                                            ,String message
                                            , String path
                                            ,LocalDateTime timestamp
                                            ,Map<String,String> fieldErrors) {
        this.statusCode = statusCode;
        this.fieldErrors = fieldErrors;
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
