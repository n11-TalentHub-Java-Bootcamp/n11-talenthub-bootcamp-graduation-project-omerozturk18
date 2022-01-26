package com.omerozturk.N11GraduationProject.cnt.services.entityservice;


import com.omerozturk.N11GraduationProject.gen.utilities.service.BaseEntityService;
import com.omerozturk.N11GraduationProject.cnt.repositories.abstracts.CntMessageDao;
import com.omerozturk.N11GraduationProject.cnt.entities.concretes.CntMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CntMessageEntityService extends BaseEntityService<CntMessage, CntMessageDao> {
    public CntMessageEntityService(CntMessageDao dao) {
        super(dao);
    }
    public List<CntMessage> findByPhoneNumber(String phoneNumber){
       return getDao().findByPhoneNumber(phoneNumber);
    }
}
