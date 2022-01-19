package com.omerozturk.N11GraduationProject.crd.utilities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CrdCreditNotFoundException extends RuntimeException {

    public CrdCreditNotFoundException(String message) {
        super(message);
    }
}
