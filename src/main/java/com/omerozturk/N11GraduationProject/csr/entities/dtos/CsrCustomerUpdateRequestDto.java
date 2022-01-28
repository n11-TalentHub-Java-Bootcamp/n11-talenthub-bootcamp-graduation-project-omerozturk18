package com.omerozturk.N11GraduationProject.csr.entities.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CsrCustomerUpdateRequestDto {
    private Long id;
    private String phoneNumber;
    private BigDecimal salary;
}
