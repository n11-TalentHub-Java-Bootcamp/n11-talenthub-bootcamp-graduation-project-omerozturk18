package com.omerozturk.N11GraduationProject.csr.entities.dtos;


import com.omerozturk.N11GraduationProject.gen.utilities.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class CsrCustomerDto implements BaseEntity {

    private Long id;
    private String identityNumber;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phoneNumber;
    private Date operationDate;

}
