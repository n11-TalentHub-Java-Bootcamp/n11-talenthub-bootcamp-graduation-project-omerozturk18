package com.omerozturk.N11GraduationProject.csr.services.concretes;

import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomer;
import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerGuarantee;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerGuaranteeDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerGuaranteeSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerGuaranteeService;

import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerService;
import com.omerozturk.N11GraduationProject.csr.services.entityservice.CsrCustomerGuaranteeEntityService;
import com.omerozturk.N11GraduationProject.csr.utilities.converter.CsrCustomerGuaranteeMapper;
import com.omerozturk.N11GraduationProject.csr.utilities.converter.CsrCustomerGuaranteeMapper;
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
public class CsrCustomerGuaranteeManager implements CsrCustomerGuaranteeService {

    private final CsrCustomerGuaranteeEntityService csrCustomerGuaranteeEntityService;
    private final CsrCustomerService csrCustomerService;

    @Override
    public DataResult<List<CsrCustomerGuaranteeDto>> findAll() {
        List<CsrCustomerGuarantee> csrCustomerGuaranteeList = csrCustomerGuaranteeEntityService.findAll();
        List<CsrCustomerGuaranteeDto> csrCustomerGuaranteeDtoList =
                CsrCustomerGuaranteeMapper.INSTANCE.convertCsrCustomerGuaranteeListToCsrCustomerGuaranteeDtoList(csrCustomerGuaranteeList);
        return new SuccessDataResult<List<CsrCustomerGuaranteeDto>>(csrCustomerGuaranteeDtoList,"Teminatlar Listelendi");
    }

    @Override
    public DataResult<CsrCustomerGuaranteeDto> findById(Long id) {
        CsrCustomerGuarantee csrCustomer = getCsrCustomerGuarantee(id);
        CsrCustomerGuaranteeDto customerGuaranteeDto =
                CsrCustomerGuaranteeMapper.INSTANCE.convertCsrCustomerGuaranteeToCsrCustomerGuaranteeDto(csrCustomer);
        return new SuccessDataResult<CsrCustomerGuaranteeDto>(customerGuaranteeDto,"Teminat Getirildi");
    }

    @Override
    public DataResult<List<CsrCustomerGuaranteeDto>> findByCustomerId(Long customerId) {
        csrCustomerService.findById(customerId);
        List<CsrCustomerGuarantee> csrCustomerGuaranteeList = csrCustomerGuaranteeEntityService.findByCustomerId(customerId);
        if (csrCustomerGuaranteeList.isEmpty()){
            throw new CsrCustomerNotFoundException("Kullanıcıya Ait Teminat Bulunanamdı!");
        }
        List<CsrCustomerGuaranteeDto> customerGuaranteeDtoList = CsrCustomerGuaranteeMapper.INSTANCE.convertCsrCustomerGuaranteeListToCsrCustomerGuaranteeDtoList(csrCustomerGuaranteeList);
        return new SuccessDataResult<List<CsrCustomerGuaranteeDto>>(customerGuaranteeDtoList,"Kullanıcının Teminatları Getirildi");
    }

    @Override
    public DataResult<CsrCustomerGuaranteeDto> save(CsrCustomerGuaranteeSaveRequestDto csrCustomerGuaranteeSaveRequestDto) {
        CsrCustomerGuarantee csrCustomerGuarantee =
                CsrCustomerGuaranteeMapper.INSTANCE.convertCsrCustomerGuaranteeSaveRequestDtoToCsrCustomerGuarantee(csrCustomerGuaranteeSaveRequestDto);
        csrCustomerGuarantee = csrCustomerGuaranteeEntityService.save(csrCustomerGuarantee);
        CsrCustomerGuaranteeDto csrCustomerGuaranteeDto =
                CsrCustomerGuaranteeMapper.INSTANCE.convertCsrCustomerGuaranteeToCsrCustomerGuaranteeDto(csrCustomerGuarantee);
        return new SuccessDataResult<CsrCustomerGuaranteeDto>(csrCustomerGuaranteeDto,"Teminat Eklendi");
    }

    @Override
    public Result delete(Long id) {
        CsrCustomerGuarantee csrCustomerGuarantee = getCsrCustomerGuarantee(id);
        csrCustomerGuaranteeEntityService.delete(csrCustomerGuarantee);
        return new SuccessResult(" Teminat Silindi");
    }

    private CsrCustomerGuarantee getCsrCustomerGuarantee(Long id){
        CsrCustomerGuarantee csrCustomerGuarantee = csrCustomerGuaranteeEntityService.findById(id);
        if (csrCustomerGuarantee == null){
            throw new CsrCustomerNotFoundException("Teminat Bulunanamdı!");
        }
        return csrCustomerGuarantee;
    }
}
