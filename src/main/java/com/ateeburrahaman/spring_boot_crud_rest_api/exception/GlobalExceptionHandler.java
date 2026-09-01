package com.ateeburrahaman.spring_boot_crud_rest_api.exception;

import com.ateeburrahaman.spring_boot_crud_rest_api.dto.responseDto.ExceptionResponseDto;
import com.ateeburrahaman.spring_boot_crud_rest_api.dto.responseDto.ValidationExceptionResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> HandleGenericException(Exception ex,
                                                                       HttpServletRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponseDto);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> HandleRunTimeException(RuntimeException ex,
                                                                       HttpServletRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponseDto);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> HandleResourceNotFoundException(ResourceNotFoundException ex
                                                                                ,HttpServletRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponseDto> HandleMethodArgumentNotValidException(MethodArgumentNotValidException ex
                                                                                        ,HttpServletRequest request) {
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(fieldError ->
                        fieldErrors.put(fieldError.getField(),
                                fieldError.getDefaultMessage()));

        ValidationExceptionResponseDto validationExceptionResponseDto
                = new ValidationExceptionResponseDto(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                "Validation Failed",
                request.getRequestURI(),
                LocalDateTime.now(),
                fieldErrors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationExceptionResponseDto);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponseDto> handleJsonError(
            HttpMessageNotReadableException ex,
            HttpServletRequest request) {

        ExceptionResponseDto response = new ExceptionResponseDto(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Invalid value for rollNo. It must be an integer.",
                request.getRequestURI(),
                LocalDateTime.now()
        );

        return ResponseEntity.badRequest().body(response);
    }
}
