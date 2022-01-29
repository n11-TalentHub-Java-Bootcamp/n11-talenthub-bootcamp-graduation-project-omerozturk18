package com.omerozturk.N11GraduationProject.cnt.entities.concretes;

import com.omerozturk.N11GraduationProject.gen.utilities.entity.BaseEntity;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CNT_MESSAGE")
@Data
public class CntMessage implements BaseEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "CNT_MESSAGE_ID_SEQ", allocationSize = 1)
    private Long id;
    private String title;
    private String contents;
    private Date operationDate;
    private Long csrCustomerId;

}
