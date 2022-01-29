package com.omerozturk.N11GraduationProject.crd.entities.dtos;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CrdCreditSaveRequestDto {
    @NotEmpty(message = "Kredi İsmi Boş Olamaz")
    private String name;
    @NotEmpty(message = "Kredi Kısa İsmi Boş Olamaz")
    private String shortName;
    @NotEmpty(message = "Kredi Açıklaması Boş Olamaz")
    private String explanation;
}
