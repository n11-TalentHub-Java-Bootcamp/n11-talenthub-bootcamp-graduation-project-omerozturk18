package com.omerozturk.N11GraduationProject.csr.services.abstracts;

import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrGuaranteeDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrGuaranteeSaveRequestDto;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;

import java.math.BigDecimal;
import java.util.List;

public interface CsrGuaranteeService {
    DataResult<List<CsrGuaranteeDto>> findAll();
    DataResult<CsrGuaranteeDto> findById(Long id);
    DataResult<List<CsrGuaranteeDto>> findByCustomerId(Long customerId);
    BigDecimal findByCustomerTotalGuarantee(Long customerId);
    DataResult<CsrGuaranteeDto> save(CsrGuaranteeSaveRequestDto csrGuaranteeSaveRequestDto);
    Result delete(Long id);
}
