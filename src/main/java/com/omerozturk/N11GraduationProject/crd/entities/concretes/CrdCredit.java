package com.omerozturk.N11GraduationProject.crd.entities.concretes;

import com.omerozturk.N11GraduationProject.gen.utilities.entity.BaseEntity;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CRD_CREDİT")
@Data
public class CrdCredit implements BaseEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "CRD_CREDİT_ID_SEQ")
    private Long id;
    private String name;
    private String shortName;
    private String explanation;
    private Date operationDate;
    private EnumStatus status;

}
