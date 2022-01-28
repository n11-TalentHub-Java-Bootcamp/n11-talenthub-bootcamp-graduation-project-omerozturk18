package com.omerozturk.N11GraduationProject.csr.services.abstracts;

import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerUpdateRequestDto;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;

import java.util.List;

public interface CsrCustomerService {
    DataResult<List<CsrCustomerDto>> findAll();
    DataResult<CsrCustomerDto> findById(Long id);
    DataResult<CsrCustomerDto> findByIdentityNumber(String identityNumber);
    DataResult<CsrCustomerDto> save(CsrCustomerSaveRequestDto csrCustomerSaveRequestDto);
    DataResult<CsrCustomerDto> update(CsrCustomerUpdateRequestDto csrCustomerUpdateRequestDto);
    Result delete(Long id);
}
