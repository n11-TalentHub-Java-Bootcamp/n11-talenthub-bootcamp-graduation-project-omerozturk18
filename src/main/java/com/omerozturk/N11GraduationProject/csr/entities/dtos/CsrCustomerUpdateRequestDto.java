package com.omerozturk.N11GraduationProject.csr.entities.dtos;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
public class CsrCustomerUpdateRequestDto {
    private Long id;
    @Pattern(message = "Telefon Numarası Rakam ve 10 Karakter Olmalıdır",regexp ="[0-9\\s]{10}")
    @NotEmpty(message = "Telefon Numarası Boş Bırakılamaz")
    private String phoneNumber;
    @DecimalMin(message = "Maaş Boş Bırakılamaz",value = "0.0")
    private BigDecimal salary;
}
