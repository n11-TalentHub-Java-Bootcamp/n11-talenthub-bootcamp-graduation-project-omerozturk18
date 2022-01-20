package com.omerozturk.N11GraduationProject.sms.entities.dtos;

import com.omerozturk.N11GraduationProject.gen.utilities.entity.BaseEntity;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import lombok.Data;

import java.util.Date;

@Data
public class CntMessageSaveRequestDto implements BaseEntity {

    private Long id;
    private String title;
    private String contents;
    private Date operationDate;
    private EnumStatus status;
    private Long csrCustomerId;

}
