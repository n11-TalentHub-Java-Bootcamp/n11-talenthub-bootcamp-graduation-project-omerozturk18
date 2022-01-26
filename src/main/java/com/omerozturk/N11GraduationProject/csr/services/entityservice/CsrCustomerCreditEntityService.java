package com.omerozturk.N11GraduationProject.csr.services.entityservice;

import com.omerozturk.N11GraduationProject.csr.repositories.abstracts.CsrCustomerCreditDao;
import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerCredit;
import com.omerozturk.N11GraduationProject.csr.entities.enums.EnumCreditResult;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import com.omerozturk.N11GraduationProject.gen.utilities.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsrCustomerCreditEntityService extends BaseEntityService<CsrCustomerCredit, CsrCustomerCreditDao> {
    public CsrCustomerCreditEntityService(CsrCustomerCreditDao dao) {
        super(dao);
    }
    public List<CsrCustomerCredit> findByCustomerId(Long customerId){
        return getDao().findByCsrCustomerId(customerId);
    }
    public List<CsrCustomerCredit> findActiveCreditsByCustomerId(Long customerId){
        return getDao().findByStatusAndCsrCustomerId(EnumStatus.ACTIVE,customerId);
    }
    public List<CsrCustomerCredit> findByCreditId(Long creditId){
        return getDao().findByCrdCreditId(creditId);
    }

    public CsrCustomerCredit findHaveSystemApprovedCreditByCustomerId(Long csrCustomerId) {
        return getDao().findByCsrCustomerIdAndAndCreditResult(csrCustomerId, EnumCreditResult.SYSTEM_APPROVED);
    }
    public List<CsrCustomerCredit> findByCustomerIdentityNumber(String identityNumber){
        return getDao().findByCustomerIdentityNumber(identityNumber);
    }
    public CsrCustomerCredit findByCustomerIdentityNumberAndSystemApproved(String identityNumber){
        return getDao().findByCustomerIdentityNumberAndSystemApproved(identityNumber);
    }
}
