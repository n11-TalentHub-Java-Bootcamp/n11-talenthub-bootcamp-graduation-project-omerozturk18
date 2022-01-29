package com.omerozturk.N11GraduationProject.gen.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler<T extends RuntimeException > extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){

        Date errorDate = new Date();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate, message, description);

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(T ex, WebRequest webRequest){

        Date errorDate = new Date();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate, message, description);

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
        List<String> collect = ex.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());
        Date errorDate = new Date();
        String message = collect.toString().substring(1,collect.toString().length()-1);
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate, message, description);

       return new ResponseEntity(exceptionResponse, status);
    }

}
