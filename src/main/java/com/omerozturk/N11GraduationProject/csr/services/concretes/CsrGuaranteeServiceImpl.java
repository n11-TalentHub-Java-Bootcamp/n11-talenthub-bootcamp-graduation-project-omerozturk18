package com.omerozturk.N11GraduationProject.csr.services.concretes;

import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrGuarantee;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrGuaranteeDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrGuaranteeSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrGuaranteeService;

import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerService;
import com.omerozturk.N11GraduationProject.csr.services.entityservice.CsrGuaranteeEntityService;
import com.omerozturk.N11GraduationProject.csr.utilities.converter.CsrGuaranteeMapper;
import com.omerozturk.N11GraduationProject.csr.utilities.exception.CsrCustomerNotFoundException;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessDataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CsrGuaranteeServiceImpl implements CsrGuaranteeService {

    private final CsrGuaranteeEntityService csrGuaranteeEntityService;
    private final CsrCustomerService csrCustomerService;

    @Override
    public DataResult<List<CsrGuaranteeDto>> findAll() {
        List<CsrGuarantee> csrGuaranteeList = csrGuaranteeEntityService.findAll();
        List<CsrGuaranteeDto> csrGuaranteeDtoList = CsrGuaranteeMapper
                .INSTANCE.convertCsrGuaranteeListToCsrGuaranteeDtoList(csrGuaranteeList);
        return new SuccessDataResult<>(csrGuaranteeDtoList,"Teminatlar Listelendi");
    }

    @Override
    public DataResult<CsrGuaranteeDto> findById(Long id) {
        CsrGuarantee csrCustomer = getCsrGuarantee(id);
        CsrGuaranteeDto customerGuaranteeDto = CsrGuaranteeMapper
                .INSTANCE.convertCsrGuaranteeToCsrGuaranteeDto(csrCustomer);
        return new SuccessDataResult<>(customerGuaranteeDto,"Teminat Getirildi");
    }

    @Override
    public DataResult<List<CsrGuaranteeDto>> findByCustomerId(Long customerId) {
        csrCustomerService.findById(customerId);
        List<CsrGuarantee> csrGuaranteeList = csrGuaranteeEntityService.findByCustomerId(customerId);
        if (csrGuaranteeList.isEmpty()){
            throw new CsrCustomerNotFoundException("Kullanıcıya Ait Teminat Bulunanamdı!");
        }
        List<CsrGuaranteeDto> customerGuaranteeDtoList = CsrGuaranteeMapper
                .INSTANCE.convertCsrGuaranteeListToCsrGuaranteeDtoList(csrGuaranteeList);
        return new SuccessDataResult<>(customerGuaranteeDtoList,"Kullanıcının Teminatları Getirildi");
    }

    @Override
    public BigDecimal findByCustomerTotalGuarantee(Long customerId) {
        BigDecimal customerTotalGuarantee = csrGuaranteeEntityService.findByCustomerTotalGuarantee(customerId);
        return customerTotalGuarantee;
    }

    @Override
    public DataResult<CsrGuaranteeDto> save(CsrGuaranteeSaveRequestDto csrGuaranteeSaveRequestDto) {
        CsrGuarantee csrGuarantee =
                CsrGuaranteeMapper.INSTANCE.convertCsrGuaranteeSaveRequestDtoToCsrGuarantee(csrGuaranteeSaveRequestDto);
        csrGuarantee.setOperationDate(new Date());
        csrGuarantee = csrGuaranteeEntityService.save(csrGuarantee);
        log.info("Customer Guarantee Saved {}", csrGuarantee);
        CsrGuaranteeDto csrGuaranteeDto = CsrGuaranteeMapper
                .INSTANCE.convertCsrGuaranteeToCsrGuaranteeDto(csrGuarantee);
        return new SuccessDataResult<>(csrGuaranteeDto,"Teminat Eklendi");
    }

    @Override
    public DataResult<List<CsrGuaranteeDto>> saveAll(List<CsrGuaranteeSaveRequestDto> csrGuaranteeSaveRequestDtoList) {
        List<CsrGuarantee> csrGuaranteeList =
                CsrGuaranteeMapper.INSTANCE.convertCsrGuaranteeSaveRequestDtoListToCsrGuaranteeList(csrGuaranteeSaveRequestDtoList);
        csrGuaranteeList.replaceAll(g->{g.setOperationDate(new Date()); return g;});

        csrGuaranteeList = csrGuaranteeEntityService.saveAllCsrGuaranteeList(csrGuaranteeList);
        log.info("Customer Guarantee List Saved {}", csrGuaranteeList);
        List<CsrGuaranteeDto> csrGuaranteeDtoList = CsrGuaranteeMapper
                .INSTANCE.convertCsrGuaranteeListToCsrGuaranteeDtoList(csrGuaranteeList);
        return new SuccessDataResult<>(csrGuaranteeDtoList,"Teminat Eklendi");
    }

    @Override
    public Result delete(Long id) {
        CsrGuarantee csrGuarantee = getCsrGuarantee(id);
        csrGuaranteeEntityService.delete(csrGuarantee);
        log.info("Customer Guarantee Deleted {}", csrGuarantee);
        return new SuccessResult(" Teminat Silindi");
    }

    private CsrGuarantee getCsrGuarantee(Long id){
        CsrGuarantee csrGuarantee = csrGuaranteeEntityService.findById(id);
        if (csrGuarantee == null){
            throw new CsrCustomerNotFoundException("Teminat Bulunanamdı!");
        }
        return csrGuarantee;
    }
}
