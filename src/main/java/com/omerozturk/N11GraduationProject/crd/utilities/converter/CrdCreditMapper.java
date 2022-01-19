package com.omerozturk.N11GraduationProject.crd.utilities.converter;



import com.omerozturk.N11GraduationProject.crd.entities.concretes.CrdCredit;
import com.omerozturk.N11GraduationProject.crd.entities.dtos.CrdCreditDto;
import com.omerozturk.N11GraduationProject.crd.entities.dtos.CrdCreditSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CrdCreditMapper {

    CrdCreditMapper INSTANCE = Mappers.getMapper(CrdCreditMapper.class);

    CrdCreditDto convertCrdCreditToCrdCreditDto(CrdCredit crdCredit);
    List<CrdCreditDto> convertCrdCreditListToCrdCreditDtoList(List<CrdCredit> crdCreditList);

    CrdCredit convertCrdCreditDtoToCrdCredit(CrdCreditDto crdCreditDto);
    List<CrdCredit> convertCrdCreditDtoListToCrdCreditList(List<CrdCreditDto> crdCreditDtoList);

    CrdCredit convertCrdCreditSaveRequestDtoToCrdCredit(CrdCreditSaveRequestDto crdCreditSaveRequestDto);
    List<CrdCredit> convertCrdCreditSaveRequestDtoListToCrdCreditList(List<CrdCreditSaveRequestDto> crdCreditSaveRequestDtoList);

}
