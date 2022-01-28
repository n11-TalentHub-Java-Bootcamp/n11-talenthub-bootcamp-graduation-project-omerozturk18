package com.omerozturk.N11GraduationProject.csr.services.concretes;

import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomer;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerUpdateRequestDto;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerService;
import com.omerozturk.N11GraduationProject.csr.services.entityservice.CsrCustomerEntityService;
import com.omerozturk.N11GraduationProject.csr.utilities.converter.CsrCustomerMapper;
import com.omerozturk.N11GraduationProject.csr.utilities.exception.CsrCustomerNotCheckRealCustomerException;
import com.omerozturk.N11GraduationProject.csr.utilities.exception.CsrCustomerNotFoundException;
import com.omerozturk.N11GraduationProject.gen.adapter.mernisAdapter.CustomerCheckService;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessDataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CsrCustomerServiceImpl implements CsrCustomerService {

    private final CsrCustomerEntityService csrCustomerEntityService;
    private final CustomerCheckService customerCheckService;

    @Override
    public DataResult<List<CsrCustomerDto>> findAll() {
        List<CsrCustomer> csrCustomerList = csrCustomerEntityService.findAll();
        List<CsrCustomerDto> csrCustomerDtoList = CsrCustomerMapper
                .INSTANCE.convertCsrCustomerListToCsrCustomerDtoList(csrCustomerList);
        return new SuccessDataResult<List<CsrCustomerDto>>(csrCustomerDtoList,"Müşteriler Listelendi");
    }

    @Override
    public DataResult<CsrCustomerDto> findById(Long id) {
        CsrCustomer csrCustomer =getCsrCustomer(id);
        CsrCustomerDto csrCustomerDto = CsrCustomerMapper
                .INSTANCE.convertCsrCustomerToCsrCustomerDto(csrCustomer);
        return new SuccessDataResult<CsrCustomerDto>(csrCustomerDto,"Müşteri Getirildi");
    }

    @Override
    public DataResult<CsrCustomerDto> findByIdentityNumber(String identityNumber) {
        CsrCustomer csrCustomer = csrCustomerEntityService.findByIdentityNumber(identityNumber);
        if (csrCustomer == null){
            throw new CsrCustomerNotFoundException("Müşteri Bulunanamdı!");
        }
        CsrCustomerDto csrCustomerDto = CsrCustomerMapper
                .INSTANCE.convertCsrCustomerToCsrCustomerDto(csrCustomer);
        return new SuccessDataResult<CsrCustomerDto>(csrCustomerDto,"Müşteri Getirildi");
    }

    @Override
    public DataResult<CsrCustomerDto> save(CsrCustomerSaveRequestDto csrCustomerSaveRequestDto) {
        CsrCustomer csrCustomer = CsrCustomerMapper
                .INSTANCE.convertCsrCustomerSaveRequestDtoToCsrCustomer(csrCustomerSaveRequestDto);
        csrCustomer= csrCustomerControl(csrCustomer);
        csrCustomer.setPhoneNumber(csrCustomerSaveRequestDto.getPhoneNumber());
        csrCustomer.setSalary(csrCustomerSaveRequestDto.getSalary());
        csrCustomer.setOperationDate(new Date());
        csrCustomer.setStatus(EnumStatus.ACTIVE);
        csrCustomer = csrCustomerEntityService.save(csrCustomer);
        log.info("Customer Saved {}", csrCustomer);
        CsrCustomerDto newCsrCustomerDto = CsrCustomerMapper
                .INSTANCE.convertCsrCustomerToCsrCustomerDto(csrCustomer);
        return new SuccessDataResult<>(newCsrCustomerDto,"İşlem Başarılı");
    }

    @Override
    public DataResult<CsrCustomerDto> update(CsrCustomerUpdateRequestDto csrCustomerUpdateRequestDto) {
        CsrCustomer csrCustomer = getCsrCustomer(csrCustomerUpdateRequestDto.getId());
        csrCustomer.setPhoneNumber(csrCustomerUpdateRequestDto.getPhoneNumber());
        csrCustomer.setSalary(csrCustomerUpdateRequestDto.getSalary());
        csrCustomer.setOperationDate(new Date());
        csrCustomer = csrCustomerEntityService.save(csrCustomer);
        log.info("Customer Updated {}", csrCustomer);
        CsrCustomerDto newCsrCustomerDto = CsrCustomerMapper
                .INSTANCE.convertCsrCustomerToCsrCustomerDto(csrCustomer);
        return new SuccessDataResult<>(newCsrCustomerDto,"İşlem Başarılı");
    }

    @Override
    public Result delete(Long id) {
        CsrCustomer csrCustomer = getCsrCustomer(id);
        csrCustomer.setOperationDate(new Date());
        csrCustomer.setStatus(EnumStatus.DELETED);
        csrCustomerEntityService.save(csrCustomer);
        log.info("Customer Deleted {}", csrCustomer);
        return new SuccessResult(" Müşteri Silindi");
    }

    private CsrCustomer getCsrCustomer(Long id){
        CsrCustomer csrCustomer = csrCustomerEntityService.findById(id);
        if (csrCustomer == null){
            throw new CsrCustomerNotFoundException("Müşteri Bulunanamdı!");
        }
        return csrCustomer;
    }
    private CsrCustomer csrCustomerControl(CsrCustomer csrCustomer){
        boolean checkIfRealCustomer = customerCheckService.checkIfRealCustomer(csrCustomer);
        if (!checkIfRealCustomer){
            throw new CsrCustomerNotCheckRealCustomerException("Müşteri Bilgileri Hatalı");
        }
        CsrCustomer responseCsrCustomer= csrCustomerEntityService.findByIdentityNumber(csrCustomer.getIdentityNumber());
        if(responseCsrCustomer!=null && responseCsrCustomer.getStatus() == EnumStatus.ACTIVE){
            return responseCsrCustomer;
        }
        return csrCustomer;
    }
}
