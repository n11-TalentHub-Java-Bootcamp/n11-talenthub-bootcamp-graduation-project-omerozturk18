package com.omerozturk.N11GraduationProject.csr.services.concretes;

import com.omerozturk.N11GraduationProject.crd.services.abstracts.CrdCreditService;
import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomer;
import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerCredit;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerDto;
import com.omerozturk.N11GraduationProject.csr.entities.enums.EnumCreditResult;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerCreditService;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerService;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrGuaranteeService;
import com.omerozturk.N11GraduationProject.csr.services.entityservice.CsrCustomerCreditEntityService;
import com.omerozturk.N11GraduationProject.csr.utilities.converter.CsrCustomerCreditMapper;
import com.omerozturk.N11GraduationProject.csr.utilities.converter.CsrCustomerMapper;
import com.omerozturk.N11GraduationProject.csr.utilities.exception.CsrCustomerCreditNotFoundException;
import com.omerozturk.N11GraduationProject.gen.adapter.creditScoreAdapter.CustomerCreditScoreService;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import com.omerozturk.N11GraduationProject.gen.utilities.result.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsrCustomerCreditServiceImpl implements CsrCustomerCreditService {

    private final CsrCustomerCreditEntityService csrCustomerCreditEntityService;
    private final CsrCustomerService csrCustomerService;
    private final CrdCreditService crdCreditService;
    private final CustomerCreditScoreService customerCreditScoreService;
    private final CsrGuaranteeService csrGuaranteeService;

    @Override
    public DataResult<List<CsrCustomerCreditDto>> findAll() {
        List<CsrCustomerCredit> csrCustomerCreditList = csrCustomerCreditEntityService.findAll();
        List<CsrCustomerCreditDto> csrCustomerCreditDtoList = CsrCustomerCreditMapper.INSTANCE.convertCsrCustomerCreditListToCsrCustomerCreditDtoList(csrCustomerCreditList);
        return new SuccessDataResult<List<CsrCustomerCreditDto>>(csrCustomerCreditDtoList,"Krediler Listelendi");
    }

    @Override
    public DataResult<CsrCustomerCreditDto> findById(Long id) {
        CsrCustomerCredit csrCustomerCredit = getCsrCustomerCredit(id);
        CsrCustomerCreditDto csrCustomerCreditDto = CsrCustomerCreditMapper.INSTANCE.convertCsrCustomerCreditToCsrCustomerCreditDto(csrCustomerCredit);
        return new SuccessDataResult<CsrCustomerCreditDto>(csrCustomerCreditDto,"Kredi Getirildi");
    }
     @Override
    public DataResult<List<CsrCustomerCreditDto>> findByCustomerId(Long customerId) {
        List<CsrCustomerCredit> csrCustomerCreditList = csrCustomerCreditEntityService.findByCustomerId(customerId);
        if (csrCustomerCreditList.isEmpty()){
            throw new CsrCustomerCreditNotFoundException("Kullanıcıya Ait Kredi Bulunanamdı!");
        }
        List<CsrCustomerCreditDto> crdCreditDtoList = CsrCustomerCreditMapper.INSTANCE.convertCsrCustomerCreditListToCsrCustomerCreditDtoList(csrCustomerCreditList);
        return new SuccessDataResult<List<CsrCustomerCreditDto>>(crdCreditDtoList,"Kullanıcının Kredileri Getirildi");
    }
    @Override
    public DataResult<List<CsrCustomerCreditDto>> findActiveCreditsByCustomerId(Long customerId) {
        List<CsrCustomerCredit> csrCustomerCreditList = csrCustomerCreditEntityService.findActiveCreditsByCustomerId(customerId);
        if (csrCustomerCreditList.isEmpty()){
            throw new CsrCustomerCreditNotFoundException("Kullanıcıya Ait Kredi Bulunanamdı!");
        }
        List<CsrCustomerCreditDto> crdCreditDtoList = CsrCustomerCreditMapper.INSTANCE.convertCsrCustomerCreditListToCsrCustomerCreditDtoList(csrCustomerCreditList);
        return new SuccessDataResult<List<CsrCustomerCreditDto>>(crdCreditDtoList,"Kullanıcının Kredileri Getirildi");
    }
     @Override
    public DataResult<List<CsrCustomerCreditDto>> findByCreditId(Long creditId) {
        List<CsrCustomerCredit> csrCustomerCreditList = csrCustomerCreditEntityService.findByCreditId(creditId);
        if (csrCustomerCreditList.isEmpty()){
            throw new CsrCustomerCreditNotFoundException("Kredi Bulunanamdı!");
        }
        List<CsrCustomerCreditDto> crdCreditDtoList = CsrCustomerCreditMapper.INSTANCE.convertCsrCustomerCreditListToCsrCustomerCreditDtoList(csrCustomerCreditList);
        return new SuccessDataResult<List<CsrCustomerCreditDto>>(crdCreditDtoList,"Kredi Türüe Göre Kredileri Getirildi");
    }



    @Override
    @Transactional
    public DataResult<CsrCustomerCreditDto> applyForCredit(CsrCustomerCreditSaveRequestDto csrCustomerCreditSaveRequestDto) {
        CsrCustomerCredit csrCustomerCredit = CsrCustomerCreditMapper.INSTANCE.convertCsrCustomerCreditSaveRequestDtoToCsrCustomerCredit(csrCustomerCreditSaveRequestDto);
        CsrCustomer csrCustomer = customerIsThere(csrCustomerCredit.getCsrCustomerId());
        CsrCustomerCredit customerHaveSystemApprovedCredit = customerHaveSystemApprovedCredit(csrCustomerCredit.getCsrCustomerId());
        if(customerHaveSystemApprovedCredit !=null){
            CsrCustomerCreditDto csrCustomerCreditDto = CsrCustomerCreditMapper.INSTANCE.convertCsrCustomerCreditToCsrCustomerCreditDto(customerHaveSystemApprovedCredit);
            return new ErrorDataResult<>(csrCustomerCreditDto,"Zaten Onay Bekleyen Bir Krediniz Var");
        }
        creditIsThere(csrCustomerCredit.getCrdCreditId());

        csrCustomerCredit=customerCreditLimit(csrCustomerCredit,csrCustomer.getIdentityNumber(),csrCustomer.getSalary().intValue());
        csrCustomerCredit.setOperationDate(new Date());

        DataResult<CsrCustomerCreditDto> csrCustomerCreditDtoDataResult = saveCustomerCredit(csrCustomerCredit);
        return csrCustomerCreditDtoDataResult;
    }

    @Override
    public Result delete(Long id) {
        CsrCustomerCredit csrCustomerCredit = getCsrCustomerCredit(id);
        csrCustomerCredit.setOperationDate(new Date());
        csrCustomerCredit.setStatus(EnumStatus.DELETED);
        csrCustomerCreditEntityService.save(csrCustomerCredit);
        return new SuccessResult(" Kredi Silindi");
    }
    private  DataResult<CsrCustomerCreditDto> saveCustomerCredit(CsrCustomerCredit csrCustomerCredit){
        csrCustomerCredit.setStatus(EnumStatus.ACTIVE);
        csrCustomerCredit.setOperationDate(new Date());
        csrCustomerCredit = csrCustomerCreditEntityService.save(csrCustomerCredit);
        CsrCustomerCreditDto csrCustomerCreditDto = CsrCustomerCreditMapper.INSTANCE.convertCsrCustomerCreditToCsrCustomerCreditDto(csrCustomerCredit);
        return new SuccessDataResult<CsrCustomerCreditDto>(csrCustomerCreditDto,"Kredi Eklendi");
    }
    private CsrCustomerCredit getCsrCustomerCredit(Long id){
        CsrCustomerCredit csrCustomerCredit = csrCustomerCreditEntityService.findById(id);
        if (csrCustomerCredit == null || csrCustomerCredit.getStatus() != EnumStatus.ACTIVE){
            throw new CsrCustomerCreditNotFoundException("Kredi Bulunanamdı!");
        }
        return csrCustomerCredit;
    }

    private CsrCustomerCredit customerHaveSystemApprovedCredit(Long csrCustomerId) {
        return csrCustomerCreditEntityService.findHaveSystemApprovedCreditByCustomerId(csrCustomerId);
    }
    private CsrCustomer customerIsThere(Long csrCustomerId) {
        DataResult<CsrCustomerDto> csrCustomerDto = csrCustomerService.findById(csrCustomerId);
        CsrCustomer csrCustomer = CsrCustomerMapper.INSTANCE.convertCsrCustomerDtoToCsrCustomer(csrCustomerDto.getData());
        return  csrCustomer;
    }
    private void creditIsThere(Long credCreditId) {
        crdCreditService.findById(credCreditId);
    }

    private CsrCustomerCredit customerCreditLimit(CsrCustomerCredit csrCustomerCredit,String identityNumber,int salary){
        int customerCreditScore = customerCreditScoreService.calculateCreditScore(Integer.parseInt(identityNumber));
        int guaranteeRate=0;
        if (customerCreditScore<500){
            csrCustomerCredit.setCreditAmount(BigDecimal.ZERO);
            csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_DENIED);
            csrCustomerCredit.setResultExplanation("Kredi Reddedildi. Kredi Skoru Yetersiz");
            return csrCustomerCredit;
        }
        else if (customerCreditScore>=500 && customerCreditScore<1000 && salary<5000){
            csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_APPROVED);
            csrCustomerCredit.setCreditAmount(new BigDecimal(10000));
            csrCustomerCredit.setResultExplanation("Kredi Onaylandı.");
            guaranteeRate=10;
        }
        else if (customerCreditScore>=500 && customerCreditScore<1000 && salary>=5000 && salary<10000){
            csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_APPROVED);
            csrCustomerCredit.setCreditAmount(new BigDecimal(20000));
            csrCustomerCredit.setResultExplanation("Kredi Onaylandı.");
            guaranteeRate=20;
        }
        else if (customerCreditScore>=500 && customerCreditScore<1000 && salary>=10000){
            csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_APPROVED);
            int creditAmount= (salary*(4/2));
            csrCustomerCredit.setCreditAmount(new BigDecimal(creditAmount));
            csrCustomerCredit.setResultExplanation("Kredi Onaylandı.");
            guaranteeRate=25;
        }
        else if (customerCreditScore >= 1000){
            int creditAmount= (salary*4);
            csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_APPROVED);
            csrCustomerCredit.setCreditAmount(new BigDecimal(creditAmount));
            csrCustomerCredit.setResultExplanation("Kredi Onaylandı.");
            guaranteeRate=50;
        }
        else {
            csrCustomerCredit.setCreditAmount(BigDecimal.ZERO);
            csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_DENIED);
            csrCustomerCredit.setResultExplanation("Kredi Reddedildi. Kredi Skoru Yetersiz");
            return csrCustomerCredit;
        }
       int totalCustomerGuarantee = csrGuaranteeService.findByTotalCustomerGuarantee(csrCustomerCredit.getCsrCustomerId()).intValue();
        if(totalCustomerGuarantee>0){
            int creditAmount = totalCustomerGuarantee * (guaranteeRate/100)+csrCustomerCredit.getCreditAmount().intValue();
            csrCustomerCredit.setCreditAmount(new BigDecimal(creditAmount));
        }
        return csrCustomerCredit;
    }
}
