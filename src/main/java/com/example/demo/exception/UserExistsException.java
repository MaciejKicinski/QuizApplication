package com.example.demo.exception;

public class UserExistsException extends RuntimeException {

    public UserExistsException(String message) {
        super(message);
    }
}
