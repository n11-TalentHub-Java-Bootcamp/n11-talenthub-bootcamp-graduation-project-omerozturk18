package com.omerozturk.N11GraduationProject.cnt.entities.dtos;


import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class CntMessageSendRequestDto {
    @NotEmpty(message = "Sms Başlığı Boş Olamaz")
    private String title;
    @NotEmpty(message = "Sms İçeriği Boş Olamaz")
    private String contents;
    private Long csrCustomerId;

}
