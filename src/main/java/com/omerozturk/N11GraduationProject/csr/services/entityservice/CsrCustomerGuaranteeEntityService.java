package com.omerozturk.N11GraduationProject.csr.services.entityservice;

import com.omerozturk.N11GraduationProject.csr.dataAccess.abstracts.CsrCustomerGuaranteeDao;
import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerGuarantee;
import com.omerozturk.N11GraduationProject.gen.utilities.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsrCustomerGuaranteeEntityService extends BaseEntityService<CsrCustomerGuarantee, CsrCustomerGuaranteeDao> {
    public CsrCustomerGuaranteeEntityService(CsrCustomerGuaranteeDao dao) {
        super(dao);
    }
    public List<CsrCustomerGuarantee> findByCustomerId(Long customerId){
        return getDao().findByCustomerId(customerId);
    }

}
