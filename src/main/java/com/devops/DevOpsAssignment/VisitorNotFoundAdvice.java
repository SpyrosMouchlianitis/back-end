package com.devops.DevOpsAssignment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VisitorNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(VisitorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String visitorNotFoundHandler(VisitorNotFoundException ex) {
        return ex.getMessage();
    }
}
