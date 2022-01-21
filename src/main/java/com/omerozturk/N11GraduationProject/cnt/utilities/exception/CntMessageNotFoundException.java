package com.omerozturk.N11GraduationProject.cnt.utilities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CntMessageNotFoundException extends RuntimeException {

    public CntMessageNotFoundException(String message) {
        super(message);
    }
}
