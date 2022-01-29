package com.omerozturk.N11GraduationProject.csr.utilities.converter;



import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomer;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CsrCustomerMapper {

    CsrCustomerMapper INSTANCE = Mappers.getMapper(CsrCustomerMapper.class);

    CsrCustomerDto convertCsrCustomerToCsrCustomerDto(CsrCustomer csrCustomer);
    List<CsrCustomerDto> convertCsrCustomerListToCsrCustomerDtoList(List<CsrCustomer> csrCustomerList);

    CsrCustomer convertCsrCustomerDtoToCsrCustomer(CsrCustomerDto csrCustomerDto);
    List<CsrCustomer> convertCsrCustomerDtoListToCsrCustomerList(List<CsrCustomerDto> csrCustomerDtoList);

    CsrCustomer convertCsrCustomerSaveRequestDtoToCsrCustomer(CsrCustomerSaveRequestDto csrCustomerSaveRequestDto);
    List<CsrCustomer> convertCsrCustomerSaveRequestDtoListToCsrCustomerList(List<CsrCustomerSaveRequestDto> csrCustomerSaveRequestDtoList);

}
