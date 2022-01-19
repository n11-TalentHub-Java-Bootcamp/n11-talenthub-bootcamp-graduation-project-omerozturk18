package com.omerozturk.N11GraduationProject.csr.services.entityservice;

import com.omerozturk.N11GraduationProject.csr.dataAccess.abstracts.CsrCustomerCreditDao;
import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerCredit;
import com.omerozturk.N11GraduationProject.gen.utilities.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsrCustomerCreditEntityService extends BaseEntityService<CsrCustomerCredit, CsrCustomerCreditDao> {
    public CsrCustomerCreditEntityService(CsrCustomerCreditDao dao) {
        super(dao);
    }
    public List<CsrCustomerCredit> findByCustomerId(Long customerId){
        return getDao().findByCustomerId(customerId);
    }
    public List<CsrCustomerCredit> findByCreditId(Long creditId){
        return getDao().findByCreditId(creditId);
    }

}
