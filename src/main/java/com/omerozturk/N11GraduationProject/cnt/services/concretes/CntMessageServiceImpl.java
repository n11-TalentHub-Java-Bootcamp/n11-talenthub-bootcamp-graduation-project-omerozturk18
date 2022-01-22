package com.omerozturk.N11GraduationProject.cnt.services.concretes;


import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessDataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessResult;
import com.omerozturk.N11GraduationProject.cnt.entities.concretes.CntMessage;
import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageDto;
import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageSaveRequestDto;
import com.omerozturk.N11GraduationProject.cnt.services.abstracts.CntMessageService;
import com.omerozturk.N11GraduationProject.cnt.services.entityservice.CntMessageEntityService;
import com.omerozturk.N11GraduationProject.cnt.utilities.converter.CntMessageMapper;
import com.omerozturk.N11GraduationProject.cnt.utilities.exception.CntMessageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CntMessageServiceImpl implements CntMessageService {

    private final CntMessageEntityService cntMessageEntityService;

    @Override
    public DataResult<List<CntMessageDto>> findAll() {
        List<CntMessage> cntMessageList = cntMessageEntityService.findAll();
        List<CntMessageDto> cntMessageDtoList = CntMessageMapper.INSTANCE.convertCntMessageListToCntMessageDtoList(cntMessageList);
        return new SuccessDataResult<List<CntMessageDto>>(cntMessageDtoList,"Smsler Listelendi");
    }

    @Override
    public DataResult<CntMessageDto> findById(Long id) {
        CntMessage cntMessage = getCntMessage(id);
        CntMessageDto cntMessageDto = CntMessageMapper.INSTANCE.convertCntMessageToCntMessageDto(cntMessage);
        return new SuccessDataResult<CntMessageDto>(cntMessageDto,"Sms Getirildi");
    }

    @Override
    public DataResult<List<CntMessageDto>> findByPhoneNumber(String phoneNumber) {
        List<CntMessage> cntMessageList = cntMessageEntityService.findByPhoneNumber(phoneNumber);
        if (cntMessageList.size() < 1){
            throw new CntMessageNotFoundException("Bu Telefon Numarasına Ait Sms Bulunanamdı!");
        }
        List<CntMessageDto> cntMessageDtoList = CntMessageMapper.INSTANCE.convertCntMessageListToCntMessageDtoList(cntMessageList);
        return new SuccessDataResult<List<CntMessageDto>>(cntMessageDtoList,"Telefon Numarasına Ait Smsler Listelendi");
    }


    @Override
    public DataResult<CntMessageDto> save(CntMessageSaveRequestDto cntMessageSaveRequestDto) {
        CntMessage cntMessage = CntMessageMapper.INSTANCE.convertCntMessageSaveRequestDtoToCntMessage(cntMessageSaveRequestDto);
        cntMessage.setOperationDate(new Date());
        cntMessage = cntMessageEntityService.save(cntMessage);
        CntMessageDto cntMessageDto = CntMessageMapper.INSTANCE.convertCntMessageToCntMessageDto(cntMessage);
        return new SuccessDataResult<CntMessageDto>(cntMessageDto,"Sms Eklendi");
    }

    @Override
    public Result delete(Long id) {
        CntMessage cntMessage = getCntMessage(id);
        cntMessageEntityService.delete(cntMessage);
        return new SuccessResult(" Sms Silindi");
    }

    private CntMessage getCntMessage(Long id){
        CntMessage cntMessage = cntMessageEntityService.findById(id);
        if (cntMessage == null){
            throw new CntMessageNotFoundException("Sms Bulunanamdı!");
        }
        return cntMessage;
    }

}
