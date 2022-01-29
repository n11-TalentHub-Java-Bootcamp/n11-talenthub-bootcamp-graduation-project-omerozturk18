package com.omerozturk.N11GraduationProject.cnt.services.concretes;

import com.omerozturk.N11GraduationProject.cnt.entities.concretes.CntMessage;
import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageDto;
import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageSendRequestDto;
import com.omerozturk.N11GraduationProject.cnt.utilities.converter.CntMessageMapper;
import com.omerozturk.N11GraduationProject.gen.utilities.entity.SmsRequest;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessDataResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CntMessageServiceImplDataProvider {
    public static DataResult<List<CntMessageDto>> convertToDtoList(List<CntMessage> cntMessageList) {
        List<CntMessageDto> cntMessageDtoList = CntMessageMapper.INSTANCE.
                convertCntMessageListToCntMessageDtoList(cntMessageList);
        DataResult<List<CntMessageDto>> dataResultCntMessageDtoList = new SuccessDataResult<List<CntMessageDto>>(cntMessageDtoList);
        return dataResultCntMessageDtoList;
    }
    public static DataResult<CntMessageDto> convertToDto(CntMessage cntMessage) {
        CntMessageDto cntMessageDto = CntMessageMapper.INSTANCE.
                convertCntMessageToCntMessageDto(cntMessage);
        DataResult<CntMessageDto> cntMessageDtoSuccessDataResult = new SuccessDataResult<>(cntMessageDto);
        return cntMessageDtoSuccessDataResult;
    }
    public static CntMessage convertToSendDto(CntMessageSendRequestDto cntMessageSendRequestDto) {
        CntMessage cntMessage = CntMessageMapper.INSTANCE.
                convertCntMessageSendRequestDtoToCntMessage(cntMessageSendRequestDto);
        return cntMessage;
    }

    public static List<CntMessage> getAllMessageList() {
        List<CntMessage> cntMessageList=new ArrayList<>();
        for(long i=1;i<=10;i++){
            CntMessage cntMessage=new CntMessage();
            cntMessage.setId(i);
            cntMessage.setTitle("Title " + i);
            cntMessage.setContents("Contents " + i);
            cntMessage.setCsrCustomerId(i);
            cntMessage.setOperationDate(new Date());

            cntMessageList.add(cntMessage);
        }
        return cntMessageList;
    }
    public  static CntMessageSendRequestDto getCntMessageSendRequest(){
        CntMessageSendRequestDto cntMessageSendRequestDto=new CntMessageSendRequestDto();
        cntMessageSendRequestDto.setTitle("Title");
        cntMessageSendRequestDto.setContents("Contents");
        cntMessageSendRequestDto.setCsrCustomerId(1L);
        return  cntMessageSendRequestDto;
    }
    public static CntMessage getCntMessageById(Long id) {
        List<CntMessage> cntMessageList = getAllMessageList();
                Optional<CntMessage> cntMessage = cntMessageList.stream().filter(c -> c.getId().equals(id)).findFirst();
        return cntMessage.get();
    }

}
