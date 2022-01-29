package com.omerozturk.N11GraduationProject.csr.utilities.converter;



import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerCredit;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CsrCustomerCreditMapper {

    CsrCustomerCreditMapper INSTANCE = Mappers.getMapper(CsrCustomerCreditMapper.class);

    CsrCustomerCreditDto convertCsrCustomerCreditToCsrCustomerCreditDto(CsrCustomerCredit csrCustomerCredit);
    List<CsrCustomerCreditDto> convertCsrCustomerCreditListToCsrCustomerCreditDtoList(List<CsrCustomerCredit> csrCustomerCreditList);

    CsrCustomerCredit convertCsrCustomerCreditDtoToCsrCustomerCredit(CsrCustomerCreditDto csrCustomerCreditDto);
    List<CsrCustomerCredit> convertCsrCustomerCreditDtoListToCsrCustomerCreditList(List<CsrCustomerCredit> csrCustomerCreditDtoList);

    @Mapping(target = "creditAmount",  ignore = true)
    @Mapping(target = "resultExplanation",  ignore = true)
    CsrCustomerCredit convertCsrCustomerCreditSaveRequestDtoToCsrCustomerCredit(CsrCustomerCreditSaveRequestDto csrCustomerCreditSaveRequestDto);
    List<CsrCustomerCredit> convertCsrCustomerCreditSaveRequestDtoListToCsrCustomerCreditList(List<CsrCustomerCreditSaveRequestDto> csrCustomerCreditSaveRequestDtoList);

}
