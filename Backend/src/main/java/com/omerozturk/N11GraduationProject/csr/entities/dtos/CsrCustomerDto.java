package com.omerozturk.N11GraduationProject.csr.entities.dtos;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CsrCustomerDto {

    private Long id;
    private String identityNumber;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phoneNumber;
    private BigDecimal salary;

}
