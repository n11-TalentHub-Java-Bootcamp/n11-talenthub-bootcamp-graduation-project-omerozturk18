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
    @SequenceGenerator(name = "generator", sequenceName = "CRD_CREDIT_ID_SEQ", allocationSize = 1)
    private Long id;
    private String name;
    private String shortName;
    private String explanation;
    private Date operationDate;
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

}
