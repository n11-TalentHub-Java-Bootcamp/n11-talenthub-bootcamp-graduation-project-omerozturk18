package com.omerozturk.N11GraduationProject.csr.services.concretes;

import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomer;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerService;
import com.omerozturk.N11GraduationProject.csr.services.entityservice.CsrCustomerEntityService;
import com.omerozturk.N11GraduationProject.csr.utilities.converter.CsrCustomerMapper;
import com.omerozturk.N11GraduationProject.csr.utilities.exception.CsrCustomerNotFoundException;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessDataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CsrCustomerManager implements CsrCustomerService {

    private final CsrCustomerEntityService csrCustomerEntityService;

    @Override
    public DataResult<List<CsrCustomerDto>> findAll() {
        List<CsrCustomer> csrCustomerList = csrCustomerEntityService.findAll();
        List<CsrCustomerDto> csrCustomerDtoList = CsrCustomerMapper.INSTANCE.convertCsrCustomerListToCsrCustomerDtoList(csrCustomerList);
        return new SuccessDataResult<List<CsrCustomerDto>>(csrCustomerDtoList,"Veriler Listelendi");
    }

    @Override
    public DataResult<CsrCustomerDto> findById(Long id) {
        CsrCustomer csrCustomer = getCsrCustomer(id);
        CsrCustomerDto csrCustomerDto = CsrCustomerMapper.INSTANCE.convertCsrCustomerToCsrCustomerDto(csrCustomer);
        return new SuccessDataResult<CsrCustomerDto>(csrCustomerDto,"Kullanıcı Getirildi");
    }

    @Override
    public DataResult<CsrCustomerDto> findByIdentityNumber(String identityNumber) {
        CsrCustomer csrCustomer = csrCustomerEntityService.findByIdentityNumber(identityNumber);
        if (csrCustomer == null){
            throw new CsrCustomerNotFoundException("Kullanıcı Bulunanamdı!");
        }
        CsrCustomerDto csrCustomerDto = CsrCustomerMapper.INSTANCE.convertCsrCustomerToCsrCustomerDto(csrCustomer);
        return new SuccessDataResult<CsrCustomerDto>(csrCustomerDto,"Kullanıcı Getirildi");
    }

    @Override
    public DataResult<CsrCustomerDto> save(CsrCustomerSaveRequestDto csrCustomerSaveRequestDto) {
        CsrCustomer csrCustomer = CsrCustomerMapper.INSTANCE.convertCsrCustomerSaveRequestDtoToCsrCustomer(csrCustomerSaveRequestDto);
        csrCustomer = csrCustomerEntityService.save(csrCustomer);
        CsrCustomerDto csrCustomerDto = CsrCustomerMapper.INSTANCE.convertCsrCustomerToCsrCustomerDto(csrCustomer);
        return new SuccessDataResult<CsrCustomerDto>(csrCustomerDto,"Kullanıcı Eklendi");
    }

    @Override
    public Result delete(Long id) {
        CsrCustomer csrCustomer = getCsrCustomer(id);
        csrCustomerEntityService.delete(csrCustomer);
        return new SuccessResult(" Kullanıcı Silindi");
    }

    private CsrCustomer getCsrCustomer(Long id){
        CsrCustomer csrCustomer = csrCustomerEntityService.findById(id);
        if (csrCustomer == null){
            throw new CsrCustomerNotFoundException("Kullanıcı Bulunanamdı!");
        }
        return csrCustomer;
    }
}
