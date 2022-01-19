package com.omerozturk.N11GraduationProject.csr.services.entityservice;

import com.omerozturk.N11GraduationProject.csr.dataAccess.abstracts.CsrGuaranteeDao;
import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrGuarantee;
import com.omerozturk.N11GraduationProject.gen.utilities.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsrGuaranteeEntityService extends BaseEntityService<CsrGuarantee, CsrGuaranteeDao> {
    public CsrGuaranteeEntityService(CsrGuaranteeDao dao) {
        super(dao);
    }
    public List<CsrGuarantee> findByCustomerId(Long customerId){
        return getDao().findByCustomerId(customerId);
    }

}
