package com.omerozturk.N11GraduationProject.csr.utilities.converter;



import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrGuarantee;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrGuaranteeDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrGuaranteeSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CsrGuaranteeMapper {

    CsrGuaranteeMapper INSTANCE = Mappers.getMapper(CsrGuaranteeMapper.class);

    CsrGuaranteeDto convertCsrGuaranteeToCsrGuaranteeDto(CsrGuarantee csrGuarantee);
    List<CsrGuaranteeDto> convertCsrGuaranteeListToCsrGuaranteeDtoList(List<CsrGuarantee> CsrGuaranteeList);

    CsrGuarantee convertCsrGuaranteeListToCsrGuarantee(CsrGuaranteeDto CsrGuaranteeDto);
    List<CsrGuarantee> convertCsrGuaranteeDtoListToCsrGuaranteeList(List<CsrGuarantee> CsrGuaranteeDtoList);

    CsrGuarantee convertCsrGuaranteeSaveRequestDtoToCsrGuarantee(CsrGuaranteeSaveRequestDto csrGuaranteeSaveRequestDto);
    List<CsrGuarantee> convertCsrGuaranteeSaveRequestDtoListToCsrGuaranteeList(List<CsrGuaranteeSaveRequestDto> csrGuaranteeSaveRequestDtoList);

}
