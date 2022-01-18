package com.omerozturk.N11GraduationProject.csr.dataAccess.abstracts;


import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsrCustomerDao extends JpaRepository<CsrCustomer, Long> {

    CsrCustomer findByIdentityNumber(String identityNumber);
}
