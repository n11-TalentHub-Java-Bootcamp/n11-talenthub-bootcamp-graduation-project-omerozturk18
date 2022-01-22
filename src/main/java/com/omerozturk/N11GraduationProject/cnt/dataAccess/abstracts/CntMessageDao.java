package com.omerozturk.N11GraduationProject.cnt.dataAccess.abstracts;


import com.omerozturk.N11GraduationProject.cnt.entities.concretes.CntMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CntMessageDao extends JpaRepository<CntMessage, Long> {
    @Query("SELECT cntMessage  FROM" +
            " CntMessage cntMessage" +
            " LEFT JOIN CsrCustomer csrCustomer on cntMessage.csrCustomerId=csrCustomer.id" +
            " WHERE csrCustomer.phoneNumber = :phoneNumber")
    List<CntMessage> findByPhoneNumber(String phoneNumber);
}
