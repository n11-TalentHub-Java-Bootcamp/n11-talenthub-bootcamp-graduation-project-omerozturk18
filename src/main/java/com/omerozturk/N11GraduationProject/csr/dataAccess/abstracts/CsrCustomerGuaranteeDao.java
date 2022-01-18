package com.omerozturk.N11GraduationProject.csr.dataAccess.abstracts;


import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerGuarantee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsrCustomerGuaranteeDao extends JpaRepository<CsrCustomerGuarantee, Long> {

    List<CsrCustomerGuarantee> findByCustomerId(Long customerId);
}
