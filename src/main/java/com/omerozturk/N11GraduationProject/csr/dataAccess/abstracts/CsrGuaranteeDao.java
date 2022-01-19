package com.omerozturk.N11GraduationProject.csr.dataAccess.abstracts;


import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrGuarantee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsrGuaranteeDao extends JpaRepository<CsrGuarantee, Long> {

    List<CsrGuarantee> findByCustomerId(Long customerId);
}
