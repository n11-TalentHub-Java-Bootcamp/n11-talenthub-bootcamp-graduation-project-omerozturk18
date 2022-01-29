package com.omerozturk.N11GraduationProject.csr.utilities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CsrCustomerNotFoundException extends RuntimeException {

    public CsrCustomerNotFoundException(String message) {
        super(message);
    }
}
