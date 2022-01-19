package com.omerozturk.N11GraduationProject.sms.utilities.converter;


import com.omerozturk.N11GraduationProject.sms.entities.concretes.CntSms;
import com.omerozturk.N11GraduationProject.sms.entities.dtos.CntSmsDto;
import com.omerozturk.N11GraduationProject.sms.entities.dtos.CntSmsSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CntSmsMapper {
    CntSmsMapper INSTANCE = Mappers.getMapper(CntSmsMapper.class);

    CntSmsDto convertCntSmsToCntSmsDto(CntSms cntSms);
    List<CntSmsDto> convertCntSmsListToCntSmsDtoList(List<CntSms> cntSmsList);

    CntSms convertCntSmsDtoToCntSms(CntSmsDto cntSmsDto);
    List<CntSms> convertCntSmsDtoListToCntSmsList(List<CntSmsDto> cntSmsDtoList);

    CntSms convertCntSmsSaveRequestDtoToCntSms(CntSmsSaveRequestDto cntSmsSaveRequestDto);
    List<CntSms> convertCntSmsSaveRequestDtoListToCntSmsList(List<CntSmsSaveRequestDto> cntSmsSaveRequestDtoList);

}
