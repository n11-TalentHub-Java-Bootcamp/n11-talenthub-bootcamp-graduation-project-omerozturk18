package com.omerozturk.N11GraduationProject.csr.repositories.abstracts;


import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrGuarantee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CsrGuaranteeDao extends JpaRepository<CsrGuarantee, Long> {

    List<CsrGuarantee> findByCsrCustomerId(Long csrCustomerId);

    @Query(value = "select sum (csrGuarantee.guaranteeAmount)" +
            " from CsrGuarantee csrGuarantee" +
            " where csrGuarantee.csrCustomerId = :csrCustomerId")
    BigDecimal findByCustomerTotalGuarantee( Long csrCustomerId);
}
