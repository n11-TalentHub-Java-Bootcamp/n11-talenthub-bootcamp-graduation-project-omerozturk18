package com.omerozturk.N11GraduationProject.csr.entities.dtos;


import com.omerozturk.N11GraduationProject.csr.entities.enums.GuaranteeType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class CsrGuaranteeDto {
    private Long id;
    private String explanation;
    private GuaranteeType guaranteeType;
    private BigDecimal guaranteeAmount;
    private Date operationDate;
    private Long customerId;

}
