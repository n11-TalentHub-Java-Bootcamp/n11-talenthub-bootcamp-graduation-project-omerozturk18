package com.omerozturk.N11GraduationProject.csr.entities.dtos;

import com.omerozturk.N11GraduationProject.csr.entities.enums.EnumCreditResult;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CsrCustomerCreditSaveRequestDto {
    private Long crdCreditId;
    private Long csrCustomerId;

}
