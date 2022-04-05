package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(value = {FizzException.class})
    public ResponseEntity<Object> handleFizzException(FizzException e){
        ApiExceptionDTO dto = new ApiExceptionDTO(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {BuzzException.class})
    public ResponseEntity<Object> handleBuzzException(BuzzException e){
        ApiExceptionDTO dto = new ApiExceptionDTO(e.getMessage(),HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(dto,HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = {FizzBuzzException.class})
    public ResponseEntity<Object> handleBuzzException(FizzBuzzException e){
        ApiExceptionDTO dto = new ApiExceptionDTO(e.getMessage(),HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(dto,HttpStatus.UNAUTHORIZED);
    }
}
