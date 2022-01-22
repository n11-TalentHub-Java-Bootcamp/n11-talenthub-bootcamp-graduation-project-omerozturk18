package com.omerozturk.N11GraduationProject.csr.entities.dtos;

import com.omerozturk.N11GraduationProject.csr.entities.enums.GuaranteeType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CsrGuaranteeSaveRequestDto {
    private String explanation;
    private BigDecimal guaranteeAmount;
    private Long customerId;
}
