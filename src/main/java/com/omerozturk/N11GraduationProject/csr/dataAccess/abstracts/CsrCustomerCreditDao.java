package com.omerozturk.N11GraduationProject.csr.dataAccess.abstracts;


import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsrCustomerCreditDao extends JpaRepository<CsrCustomerCredit, Long> {

    List<CsrCustomerCredit> findByCsrCustomerId(Long customerId);
    List<CsrCustomerCredit> findByCrdCreditId(Long creditId);
}
