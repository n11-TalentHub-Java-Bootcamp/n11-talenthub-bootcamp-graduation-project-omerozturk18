package com.omerozturk.N11GraduationProject.sms.dataAccess.abstracts;


import com.omerozturk.N11GraduationProject.sms.entities.concretes.CntSms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CntSmsDao extends JpaRepository<CntSms, Long> {
}
