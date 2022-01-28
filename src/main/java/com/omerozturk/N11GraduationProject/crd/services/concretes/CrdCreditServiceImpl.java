package com.omerozturk.N11GraduationProject.crd.services.concretes;

import com.omerozturk.N11GraduationProject.crd.entities.concretes.CrdCredit;
import com.omerozturk.N11GraduationProject.crd.entities.dtos.CrdCreditDto;
import com.omerozturk.N11GraduationProject.crd.entities.dtos.CrdCreditSaveRequestDto;
import com.omerozturk.N11GraduationProject.crd.services.abstracts.CrdCreditService;
import com.omerozturk.N11GraduationProject.crd.services.entityservice.CrdCreditEntityService;
import com.omerozturk.N11GraduationProject.crd.utilities.converter.CrdCreditMapper;
import com.omerozturk.N11GraduationProject.crd.utilities.exception.CrdCreditNotFoundException;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessDataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CrdCreditServiceImpl implements CrdCreditService {

    private final CrdCreditEntityService crdCreditEntityService;

    @Override
    public DataResult<List<CrdCreditDto>> findAll() {
        List<CrdCredit> crdCreditList = crdCreditEntityService.findAll();
        List<CrdCreditDto> crdCreditDtoList = CrdCreditMapper
                .INSTANCE.convertCrdCreditListToCrdCreditDtoList(crdCreditList);
        return new SuccessDataResult<List<CrdCreditDto>>(crdCreditDtoList,"Krediler Listelendi");
    }

    @Override
    public DataResult<CrdCreditDto> findById(Long id) {
        CrdCredit crdCustomer = getCrdCredit(id);
        CrdCreditDto crdCreditDto = CrdCreditMapper
                .INSTANCE.convertCrdCreditToCrdCreditDto(crdCustomer);
        return new SuccessDataResult<CrdCreditDto>(crdCreditDto,"Kredi Getirildi");
    }

   @Override
    public DataResult<CrdCreditDto> findByCreditName(String creditName){
       CrdCredit crdCredit = crdCreditEntityService.findByCreditName(creditName);
        if (crdCredit == null || crdCredit.getStatus() != EnumStatus.ACTIVE){
            throw new CrdCreditNotFoundException("Kredi Bulunanamdı!");
        }
        CrdCreditDto crdCreditDto = CrdCreditMapper
                .INSTANCE.convertCrdCreditToCrdCreditDto(crdCredit);
        return new SuccessDataResult<CrdCreditDto>(crdCreditDto,"Kredi Getirildi");
    }

    @Override
    public DataResult<CrdCreditDto> save(CrdCreditSaveRequestDto crdCreditSaveRequestDto) {
        CrdCredit crdCredit = CrdCreditMapper
                .INSTANCE.convertCrdCreditSaveRequestDtoToCrdCredit(crdCreditSaveRequestDto);
        crdCredit.setOperationDate(new Date());
        crdCredit.setStatus(EnumStatus.ACTIVE);
        crdCredit = crdCreditEntityService.save(crdCredit);
        log.info("Saved Credit {}", crdCredit);
        CrdCreditDto crdCreditDto = CrdCreditMapper
                .INSTANCE.convertCrdCreditToCrdCreditDto(crdCredit);
        return new SuccessDataResult<CrdCreditDto>(crdCreditDto,"Kredi Eklendi");
    }

    @Override
    public Result delete(Long id) {
        CrdCredit crdCredit = getCrdCredit(id);
        crdCredit.setOperationDate(new Date());
        crdCredit.setStatus(EnumStatus.DELETED);
        crdCredit = crdCreditEntityService.save(crdCredit);
        log.info("Deleted Credit {}", crdCredit);
        return new SuccessResult(" Kredi Silindi");
    }

    private CrdCredit getCrdCredit(Long id){
        CrdCredit crdCredit = crdCreditEntityService.findById(id);
        if (crdCredit == null || crdCredit.getStatus() != EnumStatus.ACTIVE){
            throw new CrdCreditNotFoundException("Kredi Bulunanamdı!");
        }
        return crdCredit;
    }
}
