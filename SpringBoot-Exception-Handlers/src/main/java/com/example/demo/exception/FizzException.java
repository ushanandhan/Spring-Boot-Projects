package com.example.demo.exception;

public class FizzException extends RuntimeException{

    public FizzException() {
    }

    public FizzException(String message) {
        super(message);
    }
}
