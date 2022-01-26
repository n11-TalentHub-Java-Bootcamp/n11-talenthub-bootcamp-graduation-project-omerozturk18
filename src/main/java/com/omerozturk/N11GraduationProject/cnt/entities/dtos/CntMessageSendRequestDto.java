package com.omerozturk.N11GraduationProject.cnt.entities.dtos;


import lombok.Data;


@Data
public class CntMessageSendRequestDto {
    private String title;
    private String contents;
    private Long csrCustomerId;

}
