package com.omerozturk.N11GraduationProject.sms.utilities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CntSmsNotFoundException extends RuntimeException {

    public CntSmsNotFoundException(String message) {
        super(message);
    }
}
