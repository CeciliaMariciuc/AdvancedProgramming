package com.rest.lab11.controllers;

import com.rest.lab11.exception.MyErrorResponse;
import com.rest.lab11.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = MyException.class)
    public ResponseEntity<MyErrorResponse>
    handleGenericNotFoundException(MyException e) {
        MyErrorResponse error = new MyErrorResponse(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
