package com.omerozturk.N11GraduationProject.csr.dataAccess.abstracts;


import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerCredit;
import com.omerozturk.N11GraduationProject.csr.entities.enums.EnumCreditResult;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsrCustomerCreditDao extends JpaRepository<CsrCustomerCredit, Long> {

    List<CsrCustomerCredit> findByCsrCustomerId(Long customerId);
    List<CsrCustomerCredit> findByStatusAndCsrCustomerId(EnumStatus status, Long customerId);
    List<CsrCustomerCredit> findByCrdCreditId(Long creditId);
    CsrCustomerCredit findByCrdCreditIdAndAndCreditResult(Long creditId, EnumCreditResult enumCreditResult);
}
