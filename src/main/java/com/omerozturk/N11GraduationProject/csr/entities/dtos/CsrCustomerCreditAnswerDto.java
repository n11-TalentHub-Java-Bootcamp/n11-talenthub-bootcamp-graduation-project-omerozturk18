package com.omerozturk.N11GraduationProject.csr.entities.dtos;

import com.omerozturk.N11GraduationProject.csr.entities.enums.EnumCreditResult;
import lombok.Data;

@Data
public class CsrCustomerCreditAnswerDto {
    private Long id;
    private EnumCreditResult creditResult;
    private Long crdCreditId;
    private Long csrCustomerId;
}
