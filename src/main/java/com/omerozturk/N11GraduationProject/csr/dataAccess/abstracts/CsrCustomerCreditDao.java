package com.omerozturk.N11GraduationProject.csr.dataAccess.abstracts;


import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerCredit;
import com.omerozturk.N11GraduationProject.csr.entities.enums.EnumCreditResult;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsrCustomerCreditDao extends JpaRepository<CsrCustomerCredit, Long> {

    List<CsrCustomerCredit> findByCsrCustomerId(Long customerId);
    List<CsrCustomerCredit> findByStatusAndCsrCustomerId(EnumStatus status, Long customerId);
    List<CsrCustomerCredit> findByCrdCreditId(Long creditId);
    CsrCustomerCredit findByCsrCustomerIdAndAndCreditResult(Long csrCustomerId, EnumCreditResult enumCreditResult);

    @Query("SELECT csrCustomerCredit FROM" +
            " CsrCustomerCredit csrCustomerCredit" +
            " LEFT JOIN CsrCustomer csrCustomer on csrCustomerCredit.csrCustomerId=csrCustomer.id" +
            " where csrCustomer.identityNumber = :identityNumber")
    List<CsrCustomerCredit> findByCustomerIdentityNumber(String identityNumber);

    @Query("SELECT csrCustomerCredit FROM" +
            " CsrCustomerCredit csrCustomerCredit" +
            " LEFT JOIN CsrCustomer csrCustomer on csrCustomerCredit.csrCustomerId=csrCustomer.id" +
            " where csrCustomer.identityNumber = :identityNumber and csrCustomerCredit.creditResult = 'SYSTEM_APPROVED'")
    CsrCustomerCredit findByCustomerIdentityNumberAndSystemApproved(String identityNumber);
}
