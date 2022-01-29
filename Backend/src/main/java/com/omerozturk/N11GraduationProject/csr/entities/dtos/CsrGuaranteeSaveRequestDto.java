package com.omerozturk.N11GraduationProject.csr.entities.dtos;

import com.omerozturk.N11GraduationProject.csr.entities.enums.GuaranteeType;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class CsrGuaranteeSaveRequestDto {
    @NotBlank(message = "Teminat Açıklaması Boş Bırakılamaz")
    private String explanation;
    @DecimalMin(message = "Teminat Tutarı Boş Bırakılamaz",value = "0.0")
    private BigDecimal guaranteeAmount;
    private GuaranteeType guaranteeType;
    private Long csrCustomerId;
}
