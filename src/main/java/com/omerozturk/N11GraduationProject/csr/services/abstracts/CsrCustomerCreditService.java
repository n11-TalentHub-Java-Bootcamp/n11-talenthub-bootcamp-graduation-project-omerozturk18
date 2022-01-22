package com.omerozturk.N11GraduationProject.csr.services.abstracts;

import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditAnswerDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditSaveRequestDto;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;

import java.util.List;

public interface CsrCustomerCreditService {
    DataResult<List<CsrCustomerCreditDto>> findAll();
    DataResult<CsrCustomerCreditDto> findById(Long id);
    DataResult<List<CsrCustomerCreditDto>> findByCustomerId(Long customerId);
    DataResult<List<CsrCustomerCreditDto>> findActiveCreditsByCustomerId(Long customerId);
    DataResult<List<CsrCustomerCreditDto>> findByCreditId(Long creditId);
    DataResult<CsrCustomerCreditDto> applyForCredit(CsrCustomerCreditSaveRequestDto csrCustomerCreditSaveRequestDto);
    DataResult<CsrCustomerCreditDto> customerAnswerCredit(CsrCustomerCreditAnswerDto csrCustomerCreditAnswerDto);
     Result delete(Long id);
}
