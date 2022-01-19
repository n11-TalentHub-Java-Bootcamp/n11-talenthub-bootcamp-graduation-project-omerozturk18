package com.omerozturk.N11GraduationProject.sms.entities.concretes;

import com.omerozturk.N11GraduationProject.gen.utilities.entity.BaseEntity;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CNT_SMS")
@Data
public class CntSms implements BaseEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "CNT_SMS_ID_SEQ")
    private Long id;
    private String title;
    private String contents;
    private Date operationDate;
    private EnumStatus status;
    private Long csrCustomerId;

}
