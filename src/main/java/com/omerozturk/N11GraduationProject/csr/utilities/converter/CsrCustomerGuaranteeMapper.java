package com.omerozturk.N11GraduationProject.csr.utilities.converter;



import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerGuarantee;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerGuaranteeDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CsrCustomerGuaranteeMapper {

    CsrCustomerGuaranteeMapper INSTANCE = Mappers.getMapper(CsrCustomerGuaranteeMapper.class);

    CsrCustomerGuaranteeDto convertCsrCustomerGuaranteeToCsrCustomerGuaranteeDto(CsrCustomerGuarantee csrCustomerGuarantee);
    List<CsrCustomerGuaranteeDto> convertCsrCustomerGuaranteeListToCsrCustomerGuaranteeList(List<CsrCustomerGuarantee> CsrCustomerGuaranteeList);

    CsrCustomerGuarantee convertCsrCustomerGuaranteeListToCsrCustomerGuarantee(CsrCustomerGuaranteeDto CsrCustomerGuaranteeDto);
    List<CsrCustomerGuarantee> convertCsrCustomerGuaranteeDtoListToCsrCustomerGuaranteeList(List<CsrCustomerGuarantee> CsrCustomerGuaranteeDtoList);

}
