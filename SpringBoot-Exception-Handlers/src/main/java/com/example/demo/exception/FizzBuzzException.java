package com.example.demo.exception;

public class FizzBuzzException extends RuntimeException{

    public FizzBuzzException(){}

    public FizzBuzzException(String message){
        super(message);
    }
}
