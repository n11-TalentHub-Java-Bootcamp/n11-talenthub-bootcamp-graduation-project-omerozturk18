package com.omerozturk.N11GraduationProject.csr.services.entityservice;

import com.omerozturk.N11GraduationProject.csr.dataAccess.abstracts.CsrCustomerDao;
import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomer;
import com.omerozturk.N11GraduationProject.gen.utilities.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class CsrCustomerEntityService extends BaseEntityService<CsrCustomer, CsrCustomerDao> {
    public CsrCustomerEntityService(CsrCustomerDao dao) {
        super(dao);
    }
    public CsrCustomer findByIdentityNumber(String identityNumber){
        return getDao().findByIdentityNumber(identityNumber);
    }

}
