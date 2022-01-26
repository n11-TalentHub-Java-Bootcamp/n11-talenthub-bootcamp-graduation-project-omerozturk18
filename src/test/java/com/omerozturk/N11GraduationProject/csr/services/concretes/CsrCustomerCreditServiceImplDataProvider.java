package com.omerozturk.N11GraduationProject.csr.services.concretes;

import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerCredit;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditResponseDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.entities.enums.EnumCreditResult;
import com.omerozturk.N11GraduationProject.csr.utilities.converter.CsrCustomerCreditMapper;
import com.omerozturk.N11GraduationProject.csr.utilities.exception.CsrCustomerCreditNotFoundException;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessDataResult;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsrCustomerCreditServiceImplDataProvider {
    public static DataResult<List<CsrCustomerCreditDto>> convertToDtoList(List<CsrCustomerCredit> csrCustomerCreditList) {
        List<CsrCustomerCreditDto> csrCustomerCreditDtoList = CsrCustomerCreditMapper.INSTANCE.
                convertCsrCustomerCreditListToCsrCustomerCreditDtoList(csrCustomerCreditList);
        DataResult<List<CsrCustomerCreditDto>> dataResultCsrCustomerCreditDtoList = new SuccessDataResult<List<CsrCustomerCreditDto>>(csrCustomerCreditDtoList);
        return dataResultCsrCustomerCreditDtoList;
    }
    public static DataResult<CsrCustomerCreditDto> convertToDto(CsrCustomerCredit csrCustomerCredit) {
        CsrCustomerCreditDto csrCustomerCreditDto = CsrCustomerCreditMapper.INSTANCE.
                convertCsrCustomerCreditToCsrCustomerCreditDto(csrCustomerCredit);
        DataResult<CsrCustomerCreditDto> csrCustomerCreditDtoSuccessDataResult = new SuccessDataResult<>(csrCustomerCreditDto);
        return csrCustomerCreditDtoSuccessDataResult;
    }
    public static CsrCustomerCredit convertToSaveDto(CsrCustomerCreditSaveRequestDto csrCustomerCreditSaveRequestDto) {
        CsrCustomerCredit csrCustomerCredit = CsrCustomerCreditMapper.INSTANCE.
                convertCsrCustomerCreditSaveRequestDtoToCsrCustomerCredit(csrCustomerCreditSaveRequestDto);
        return csrCustomerCredit;
    }

    public static List<CsrCustomerCredit> getAllCustomerCreditList() {
        List<CsrCustomerCredit> csrCustomerCreditList=new ArrayList<>();
        long id=1L;
        for(long i=1;i<=10;i++){
            if(i%2==0){
                id=i+1;
            }
            CsrCustomerCredit csrCustomerCredit=new CsrCustomerCredit();
            csrCustomerCredit.setId(i);
            csrCustomerCredit.setCreditAmount(new BigDecimal(5000));
            csrCustomerCredit.setOperationDate(new Date());
            csrCustomerCredit.setCsrCustomerId(id);
            csrCustomerCredit.setCrdCreditId(id);
            csrCustomerCredit.setStatus(i==10L?EnumStatus.DELETED:EnumStatus.ACTIVE);
            csrCustomerCredit.setResultExplanation("Onaylandı "+ i);
            csrCustomerCredit.setCreditResult(EnumCreditResult.CUSTOMER_DENIED);
            csrCustomerCreditList.add(csrCustomerCredit);
        }
        return csrCustomerCreditList;
    }
    public  static CsrCustomerCreditSaveRequestDto getCsrCustomerCreditSaveRequest(){
        CsrCustomerCreditSaveRequestDto csrCustomerCreditSaveRequestDto=new CsrCustomerCreditSaveRequestDto();
        csrCustomerCreditSaveRequestDto.setCsrCustomerId(1L);
        csrCustomerCreditSaveRequestDto.setCrdCreditId(1L);
        return  csrCustomerCreditSaveRequestDto;
    }
    public static CsrCustomerCredit getCsrCustomerCreditById(Long id) {
        List<CsrCustomerCredit> csrCustomerCreditList = getAllCustomerCreditList();
                Optional<CsrCustomerCredit> csrCustomerCredit = csrCustomerCreditList.stream().filter(c -> c.getId().equals(id)).findFirst();
        return csrCustomerCredit.get();
    }
    public static List<CsrCustomerCredit> getCsrCustomerCreditsByCustomerId(Long id) {
        List<CsrCustomerCredit> csrCustomerCreditList = getAllCustomerCreditList();
        List<CsrCustomerCredit> csrCustomerCreditListByCustomerId =csrCustomerCreditList.stream().filter(c -> c.getCsrCustomerId().equals(id)).collect(Collectors.toList());
        return csrCustomerCreditListByCustomerId;
    }
    public static List<CsrCustomerCredit> getCsrCustomerCreditsByCreditId(Long id) {
        List<CsrCustomerCredit> csrCustomerCreditList = getAllCustomerCreditList();
        List<CsrCustomerCredit> csrCustomerCreditListByCustomerId =csrCustomerCreditList.stream().filter(c -> c.getCrdCreditId().equals(id)).collect(Collectors.toList());
        return csrCustomerCreditListByCustomerId;
    }
    public static CsrCustomerCredit getDeniedCsrCustomerCredit() {
        CsrCustomerCredit csrCustomerCredit=new CsrCustomerCredit();
        csrCustomerCredit.setId(1L);
        csrCustomerCredit.setCreditAmount(new BigDecimal(8000));
        csrCustomerCredit.setOperationDate(new Date());
        csrCustomerCredit.setCsrCustomerId(1L);
        csrCustomerCredit.setCrdCreditId(1L);
        csrCustomerCredit.setStatus(EnumStatus.ACTIVE);
        csrCustomerCredit.setResultExplanation("Onaylandı ");
        csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_DENIED);
        return csrCustomerCredit;
    }
    public static CsrCustomerCredit getApprovedCsrCustomerCredit() {
        CsrCustomerCredit csrCustomerCredit=new CsrCustomerCredit();
        csrCustomerCredit.setId(1L);
        csrCustomerCredit.setCreditAmount(new BigDecimal(8000));
        csrCustomerCredit.setOperationDate(new Date());
        csrCustomerCredit.setCsrCustomerId(1L);
        csrCustomerCredit.setCrdCreditId(1L);
        csrCustomerCredit.setStatus(EnumStatus.ACTIVE);
        csrCustomerCredit.setResultExplanation("Onaylandı ");
        csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_APPROVED);
        return csrCustomerCredit;
    }

    public static CsrCustomerCreditResponseDto getCustomerCreditResponseDto(EnumCreditResult enumCreditResult) {
        CsrCustomerCreditResponseDto csrCustomerCreditResponseDto=new CsrCustomerCreditResponseDto();
        csrCustomerCreditResponseDto.setId(1L);
        csrCustomerCreditResponseDto.setCreditResult(enumCreditResult);
        csrCustomerCreditResponseDto.setCrdCreditId(1L);
        csrCustomerCreditResponseDto.setCsrCustomerId(1L);
        csrCustomerCreditResponseDto.setId(1L);
        return csrCustomerCreditResponseDto;
    }
}
