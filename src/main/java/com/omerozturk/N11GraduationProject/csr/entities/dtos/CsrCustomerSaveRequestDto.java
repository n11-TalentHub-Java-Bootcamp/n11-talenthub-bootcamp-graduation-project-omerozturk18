package com.omerozturk.N11GraduationProject.csr.entities.dtos;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CsrCustomerSaveRequestDto {
    @Pattern(message = "Kimlik No Rakam ve 11 Karakter Olmalıdır",regexp ="[0-9\\s]{11}")
    @NotEmpty(message = "Kimlik No boş bırakılamaz")
    private String identityNumber;
    @NotEmpty(message = "İsim Boş Bırakılamaz")
    private String firstName;
    @NotEmpty(message = "Soyisim Boş Bırakılamaz")
    private String lastName;
    private Date dateOfBirth;
    @Pattern(message = "Telefon Numarası Rakam ve 10 Karakter Olmalıdır",regexp ="[0-9\\s]{10}")
    @NotEmpty(message = "Telefon Numarası Boş Bırakılamaz")
    private String phoneNumber;
    @DecimalMin(message = "Maaş Boş Bırakılamaz",value = "0.0")
    private BigDecimal salary;
}
