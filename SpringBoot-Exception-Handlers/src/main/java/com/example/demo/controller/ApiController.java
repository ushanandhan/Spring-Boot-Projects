package com.example.demo.controller;

import com.example.demo.exception.BuzzException;
import com.example.demo.exception.FizzBuzzException;
import com.example.demo.exception.FizzException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/controller/{request}")
    public ResponseEntity fizzbuzzException(@PathVariable String request){
        if(request.equalsIgnoreCase("fizz")){
            throw new FizzException("Throwing fizz Exception");
        }else if(request.equalsIgnoreCase("buzz")){
            throw new BuzzException("Throwing buzz Exception");
        }else if(request.equalsIgnoreCase("fizzbuzz")){
            throw new FizzBuzzException("Global Error");
        }
        return new ResponseEntity(request, HttpStatus.OK);
    }
}
