package com.omerozturk.N11GraduationProject.csr.entities.dtos;


import com.omerozturk.N11GraduationProject.csr.entities.enums.EnumCreditResult;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class CsrCustomerCreditDto {
    private Long id;
    private BigDecimal creditAmount;
    private String resultExplanation;
    private EnumCreditResult creditResult;
    private EnumStatus status;
    private Date operationDate;
    private Long crdCreditId;
    private Long csrCustomerId;

}
