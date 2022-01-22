package com.omerozturk.N11GraduationProject.csr.entities.concretes;


import com.omerozturk.N11GraduationProject.csr.entities.enums.EnumCreditResult;
import com.omerozturk.N11GraduationProject.gen.utilities.entity.BaseEntity;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import lombok.Data;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "CSR_CUSTOMER_CREDİT")
@Data
public class CsrCustomerCredit implements BaseEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "CSR_CUSTOMER_CREDIT_ID_SEQ")
    private Long id;
    private BigDecimal creditAmount;
    private String resultExplanation;
    private EnumCreditResult creditResult;
    private EnumStatus status;
    private Date operationDate;
    private Long crdCreditId;
    private Long csrCustomerId;
}
