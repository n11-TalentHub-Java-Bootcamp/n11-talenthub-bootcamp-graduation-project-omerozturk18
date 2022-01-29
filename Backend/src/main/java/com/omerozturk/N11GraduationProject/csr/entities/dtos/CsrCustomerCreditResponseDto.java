package com.omerozturk.N11GraduationProject.csr.entities.dtos;

import com.omerozturk.N11GraduationProject.csr.entities.enums.EnumCreditResult;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CsrCustomerCreditResponseDto {
    private Long id;
    private EnumCreditResult creditResult;
    private Long crdCreditId;
    private Long csrCustomerId;
}
