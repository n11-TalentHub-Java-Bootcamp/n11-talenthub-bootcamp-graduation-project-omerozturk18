package com.omerozturk.N11GraduationProject.csr.services.abstracts;

import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerGuaranteeDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerGuaranteeSaveRequestDto;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;

import java.util.List;

public interface CsrCustomerGuaranteeService {
    DataResult<List<CsrCustomerGuaranteeDto>> findAll();
    DataResult<CsrCustomerGuaranteeDto> findById(Long id);
    DataResult<List<CsrCustomerGuaranteeDto>> findByCustomerId(Long customerId);
    DataResult<CsrCustomerGuaranteeDto> save(CsrCustomerGuaranteeSaveRequestDto csrCustomerGuaranteeSaveRequestDto);
    Result delete(Long id);
}
