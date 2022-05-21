package com.example.learningcenter.exceptions;

public class AlreadyExistException extends RuntimeException{

    public AlreadyExistException(String message) {
        super(message);
    }
}
