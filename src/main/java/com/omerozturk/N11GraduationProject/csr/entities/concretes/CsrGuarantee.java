package com.omerozturk.N11GraduationProject.csr.entities.concretes;


import com.omerozturk.N11GraduationProject.csr.entities.enums.GuaranteeType;
import com.omerozturk.N11GraduationProject.gen.utilities.entity.BaseEntity;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CSR_GUARANTEE")
@Data
public class CsrGuarantee implements BaseEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "CSR_GUARANTEE_ID_SEQ")
    private Long id;
    private String explanation;
    private GuaranteeType guaranteeType;
    private BigDecimal guaranteeAmount;
    private Date operationDate;
    private Long customerId;
}
