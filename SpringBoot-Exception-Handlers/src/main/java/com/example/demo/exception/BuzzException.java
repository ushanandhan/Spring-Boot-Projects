package com.example.demo.exception;

public class BuzzException extends RuntimeException{

    public BuzzException() {
    }

    public BuzzException(String message) {
        super(message);
    }
}
