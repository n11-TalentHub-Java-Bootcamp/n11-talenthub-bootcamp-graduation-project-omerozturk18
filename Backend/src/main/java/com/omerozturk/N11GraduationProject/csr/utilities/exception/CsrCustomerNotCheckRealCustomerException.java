package com.omerozturk.N11GraduationProject.csr.utilities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CsrCustomerNotCheckRealCustomerException extends RuntimeException {

    public CsrCustomerNotCheckRealCustomerException(String message) {
        super(message);
    }
}
