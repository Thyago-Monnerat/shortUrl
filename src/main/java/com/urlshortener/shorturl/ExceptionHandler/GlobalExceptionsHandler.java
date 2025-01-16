package com.urlshortener.shorturl.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.NoSuchAlgorithmException;

@ControllerAdvice
public class GlobalExceptionsHandler{
    @ExceptionHandler(NoSuchAlgorithmException.class)
    public ResponseEntity<String> noSuchAlgorithmException(NoSuchAlgorithmException exception){
        return new ResponseEntity<>("Erro no algoritmo de hash: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
