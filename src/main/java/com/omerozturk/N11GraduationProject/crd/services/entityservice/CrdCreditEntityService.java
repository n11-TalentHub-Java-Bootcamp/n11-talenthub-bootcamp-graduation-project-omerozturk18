package com.omerozturk.N11GraduationProject.crd.services.entityservice;


import com.omerozturk.N11GraduationProject.crd.dataAccess.abstracts.CrdCreditDao;
import com.omerozturk.N11GraduationProject.crd.entities.concretes.CrdCredit;
import com.omerozturk.N11GraduationProject.gen.utilities.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CrdCreditEntityService extends BaseEntityService<CrdCredit, CrdCreditDao> {
    public CrdCreditEntityService(CrdCreditDao dao) {
        super(dao);
    }
    public CrdCredit findByCreditName(String creditName){
        return getDao().findByName(creditName);
    }

}
