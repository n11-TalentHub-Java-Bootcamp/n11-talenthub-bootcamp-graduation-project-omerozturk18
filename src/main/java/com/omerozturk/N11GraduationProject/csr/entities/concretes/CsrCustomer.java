package com.omerozturk.N11GraduationProject.csr.entities.concretes;

import com.omerozturk.N11GraduationProject.gen.utilities.entity.BaseEntity;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import lombok.Data;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CSR_CUSTOMER")
@Data
public class CsrCustomer implements BaseEntity {

    @Id
    @GeneratedValue(generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "CSR_CUSTOMER_ID_SEQ")
    private Long id;
    private String identityNumber;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phoneNumber;
    private BigDecimal salary;
    private Date operationDate;
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

}
