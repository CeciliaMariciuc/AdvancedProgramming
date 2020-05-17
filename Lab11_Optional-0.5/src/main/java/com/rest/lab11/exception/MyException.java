package com.rest.lab11.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No game with this id!")
public class MyException extends RuntimeException{
    public MyException(String id) {
        super("No game with this id: " + id);
    }

}
