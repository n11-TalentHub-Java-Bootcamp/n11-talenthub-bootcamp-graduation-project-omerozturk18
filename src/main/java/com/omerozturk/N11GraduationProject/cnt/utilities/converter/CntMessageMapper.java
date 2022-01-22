package com.omerozturk.N11GraduationProject.cnt.utilities.converter;


import com.omerozturk.N11GraduationProject.cnt.entities.concretes.CntMessage;
import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageDto;
import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageSendRequestDto;
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

    CntMessage convertCntMessageSendRequestDtoToCntMessage(CntMessageSendRequestDto cntMessageSendRequestDto);
    List<CntMessage> convertCntMessageSendRequestDtoListToCntMessageList(List<CntMessageSendRequestDto> cntMessageSendRequestDtoList);

}
