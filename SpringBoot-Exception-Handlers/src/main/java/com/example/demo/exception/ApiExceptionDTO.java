package com.example.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiExceptionDTO {

    private String message;
    private HttpStatus status;

    ApiExceptionDTO(String message, HttpStatus status){
        this.message = message;
        this.status = status;
    }


}
