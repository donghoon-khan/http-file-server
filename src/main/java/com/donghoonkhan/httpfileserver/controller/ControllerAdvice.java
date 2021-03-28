package com.donghoonkhan.httpfileserver.controller;

import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.Date;

import com.donghoonkhan.httpfileserver.model.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class ControllerAdvice {
    
    @ExceptionHandler(value = {FileSystemNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleFileSystemNotFoundException(FileSystemNotFoundException e) {
        ErrorResponse response = new ErrorResponse();
        response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setTimeStamp(new Date());
        response.setMessage(e.getMessage());
        return response;
    }

    @ExceptionHandler(value = {IOException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleIOException(IOException e) {
        ErrorResponse response = new ErrorResponse();
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setTimeStamp(new Date());
        response.setMessage(e.getMessage());
        return response;
    }
}
