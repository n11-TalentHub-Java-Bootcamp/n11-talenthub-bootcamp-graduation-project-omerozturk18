package com.omerozturk.N11GraduationProject.sms.utilities.converter;


import com.omerozturk.N11GraduationProject.sms.entities.concretes.CntMessage;
import com.omerozturk.N11GraduationProject.sms.entities.dtos.CntMessageDto;
import com.omerozturk.N11GraduationProject.sms.entities.dtos.CntMessageSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CntMessageMapper {
    CntMessageMapper INSTANCE = Mappers.getMapper(CntMessageMapper.class);

    CntMessageDto convertCntMessageToCntMessageDto(CntMessage cntSms);
    List<CntMessageDto> convertCntMessageListToCntMessageDtoList(List<CntMessage> cntSmsList);

    CntMessage convertCntMessageDtoToCntMessage(CntMessageDto cntSmsDto);
    List<CntMessage> convertCntMessageDtoListToCntMessageList(List<CntMessageDto> cntSmsDtoList);

    CntMessage convertCntMessageSaveRequestDtoToCntMessage(CntMessageSaveRequestDto cntSmsSaveRequestDto);
    List<CntMessage> convertCntMessageSaveRequestDtoListToCntMessageList(List<CntMessageSaveRequestDto> cntSmsSaveRequestDtoList);

}
