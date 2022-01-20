package com.omerozturk.N11GraduationProject.csr.services.concretes;

import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerCredit;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerCreditService;
import com.omerozturk.N11GraduationProject.csr.services.entityservice.CsrCustomerCreditEntityService;
import com.omerozturk.N11GraduationProject.csr.utilities.converter.CsrCustomerCreditMapper;
import com.omerozturk.N11GraduationProject.csr.utilities.exception.CsrCustomerCreditNotFoundException;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessDataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CsrCustomerCreditManager implements CsrCustomerCreditService {

    private final CsrCustomerCreditEntityService csrCustomerCreditEntityService;

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
    public DataResult<List<CsrCustomerCreditDto>> findByCreditId(Long creditId) {
        List<CsrCustomerCredit> csrCustomerCreditList = csrCustomerCreditEntityService.findByCreditId(creditId);
        if (csrCustomerCreditList.isEmpty()){
            throw new CsrCustomerCreditNotFoundException("Kredi Bulunanamdı!");
        }
        List<CsrCustomerCreditDto> crdCreditDtoList = CsrCustomerCreditMapper.INSTANCE.convertCsrCustomerCreditListToCsrCustomerCreditDtoList(csrCustomerCreditList);
        return new SuccessDataResult<List<CsrCustomerCreditDto>>(crdCreditDtoList,"Kredi Türüe Göre Kredileri Getirildi");
    }

    @Override
    public DataResult<CsrCustomerCreditDto> save(CsrCustomerCreditSaveRequestDto csrCustomerCreditSaveRequestDto) {
        CsrCustomerCredit csrCustomerCredit = CsrCustomerCreditMapper.INSTANCE.convertCsrCustomerCreditSaveRequestDtoToCsrCustomerCredit(csrCustomerCreditSaveRequestDto);
        customerCreditControl(csrCustomerCredit);
        csrCustomerCredit = csrCustomerCreditEntityService.save(csrCustomerCredit);
        CsrCustomerCreditDto csrCustomerCreditDto = CsrCustomerCreditMapper.INSTANCE.convertCsrCustomerCreditToCsrCustomerCreditDto(csrCustomerCredit);
        return new SuccessDataResult<CsrCustomerCreditDto>(csrCustomerCreditDto,"Kredi Eklendi");
    }

    @Override
    public Result delete(Long id) {
        CsrCustomerCredit csrCustomerCredit = getCsrCustomerCredit(id);
        csrCustomerCreditEntityService.delete(csrCustomerCredit);
        return new SuccessResult(" Kredi Silindi");
    }

    private CsrCustomerCredit getCsrCustomerCredit(Long id){
        CsrCustomerCredit csrCustomerCredit = csrCustomerCreditEntityService.findById(id);
        if (csrCustomerCredit == null){
            throw new CsrCustomerCreditNotFoundException("Kredi Bulunanamdı!");
        }
        return csrCustomerCredit;
    }
    private boolean customerCreditControl(CsrCustomerCredit csrCustomerCredit){
        //todo:sms service eklenecek
        return false;
    }
}
