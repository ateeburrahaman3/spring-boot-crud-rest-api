package com.ateeburrahaman.spring_boot_crud_rest_api.dto.responseDto;

import java.time.LocalDateTime;

public class ExceptionResponseDto {
    private int statusCode;
    private String error;
    private String path;
    private String message;
    private LocalDateTime timestamp;

    public ExceptionResponseDto(int statusCode
                                , String error
                                ,String message
                                , String path
                                ,LocalDateTime timestamp) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
        this.error = error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
