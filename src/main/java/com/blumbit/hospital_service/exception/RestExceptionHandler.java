package com.blumbit.hospital_service.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blumbit.hospital_service.common.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse<String>> handleRuntimeException(RuntimeException ex, HttpServletRequest request){
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorResponse<String>(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), Instant.now().toString(), request.getRequestURI()),
        new HttpHeaders(),
        HttpStatus.INTERNAL_SERVER_ERROR
        );               
    } 

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse<Map<String, String>>> handleValidationsException(MethodArgumentNotValidException ex, HttpServletRequest request){
        log.error(ex.getMessage(), ex);
        Map<String, String> errors = new HashMap<>();
        
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(new ErrorResponse<Map<String, String>>(HttpStatus.INTERNAL_SERVER_ERROR, errors, Instant.now().toString(), request.getRequestURI()),
        new HttpHeaders(),
        HttpStatus.NOT_FOUND
        );               
    } 

}
