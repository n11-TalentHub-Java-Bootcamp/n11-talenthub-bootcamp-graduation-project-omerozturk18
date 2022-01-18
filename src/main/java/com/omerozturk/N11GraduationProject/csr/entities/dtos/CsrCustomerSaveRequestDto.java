package com.omerozturk.N11GraduationProject.csr.entities.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CsrCustomerSaveRequestDto {
    private String identityNumber;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phoneNumber;
    private Date operationDate;
}
