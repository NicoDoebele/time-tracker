package com.company.timetracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.timetracker.exceptions.PersonNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlePersonNotFoundException(PersonNotFoundException ex){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
    

    public class ErrorResponse {

        private int status;
        private String message;
    
        public ErrorResponse(int status, String message) {
            this.status = status;
            this.message = message;
        }
    
        public int getStatus() {
            return status;
        }
    
        public void setStatus(int status) {
            this.status = status;
        }
    
        public String getMessage() {
            return message;
        }
    
        public void setMessage(String message) {
            this.message = message;
        }
    }

}
