package com.omerozturk.N11GraduationProject.crd.dataAccess.abstracts;


import com.omerozturk.N11GraduationProject.crd.entities.concretes.CrdCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrdCreditDao extends JpaRepository<CrdCredit, Long> {
        CrdCredit findByName(String creditName);

}
