package com.omerozturk.N11GraduationProject.sms.services.entityservice;


import com.omerozturk.N11GraduationProject.gen.utilities.service.BaseEntityService;
import com.omerozturk.N11GraduationProject.sms.dataAccess.abstracts.CntSmsDao;
import com.omerozturk.N11GraduationProject.sms.entities.concretes.CntSms;
import org.springframework.stereotype.Service;

@Service
public class CntSmsEntityService extends BaseEntityService<CntSms, CntSmsDao> {
    public CntSmsEntityService(CntSmsDao dao) {
        super(dao);
    }


}
