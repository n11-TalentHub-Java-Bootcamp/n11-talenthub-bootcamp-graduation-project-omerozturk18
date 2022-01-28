package com.omerozturk.N11GraduationProject.cnt.services.concretes;


import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerDto;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerService;
import com.omerozturk.N11GraduationProject.gen.adapter.twilioAdapter.TwilioService;
import com.omerozturk.N11GraduationProject.gen.utilities.entity.SmsRequest;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessDataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessResult;
import com.omerozturk.N11GraduationProject.cnt.entities.concretes.CntMessage;
import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageDto;
import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageSendRequestDto;
import com.omerozturk.N11GraduationProject.cnt.services.abstracts.CntMessageService;
import com.omerozturk.N11GraduationProject.cnt.services.entityservice.CntMessageEntityService;
import com.omerozturk.N11GraduationProject.cnt.utilities.converter.CntMessageMapper;
import com.omerozturk.N11GraduationProject.cnt.utilities.exception.CntMessageNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CntMessageServiceImpl implements CntMessageService {

    private final CntMessageEntityService cntMessageEntityService;
    private final CsrCustomerService csrCustomerService;
    private final TwilioService twilioService;

    @Override
    public DataResult<List<CntMessageDto>> findAll() {
        List<CntMessage> cntMessageList = cntMessageEntityService.findAll();

        List<CntMessageDto> cntMessageDtoList = CntMessageMapper.INSTANCE
                .convertCntMessageListToCntMessageDtoList(cntMessageList);
        return new SuccessDataResult<List<CntMessageDto>>(cntMessageDtoList,"Smsler Listelendi");
    }

    @Override
    public DataResult<CntMessageDto> findById(Long id) {
        CntMessage cntMessage = getCntMessage(id);

        CntMessageDto cntMessageDto = CntMessageMapper.INSTANCE.
                convertCntMessageToCntMessageDto(cntMessage);
        return new SuccessDataResult<CntMessageDto>(cntMessageDto,"Sms Getirildi");
    }

    @Override
    public DataResult<List<CntMessageDto>> findByPhoneNumber(String phoneNumber) {
        List<CntMessage> cntMessageList = cntMessageEntityService.findByPhoneNumber(phoneNumber);
        if (cntMessageList.size() < 1){
            throw new CntMessageNotFoundException("Bu Telefon Numarasına Ait Sms Bulunanamdı!");
        }

        List<CntMessageDto> cntMessageDtoList = CntMessageMapper.INSTANCE
                .convertCntMessageListToCntMessageDtoList(cntMessageList);
        return new SuccessDataResult<List<CntMessageDto>>(cntMessageDtoList,"Telefon Numarasına Ait Smsler Listelendi");
    }


    @Override
    public DataResult<CntMessageDto> sendMessage(CntMessageSendRequestDto cntMessageSaveRequestDto) {
        CntMessage cntMessage = CntMessageMapper.INSTANCE
                .convertCntMessageSendRequestDtoToCntMessage(cntMessageSaveRequestDto);

        cntMessage.setOperationDate(new Date());
        DataResult<CsrCustomerDto> customerDtoDataResult = csrCustomerService.findById(cntMessage.getCsrCustomerId());

        SmsRequest smsRequest=new SmsRequest(customerDtoDataResult.getData().getPhoneNumber(),cntMessage.getContents());
        twilioService.sendSms(smsRequest);
        cntMessage = cntMessageEntityService.save(cntMessage);

        log.info("Save sms {}", cntMessage);

        CntMessageDto cntMessageDto = CntMessageMapper.INSTANCE
                .convertCntMessageToCntMessageDto(cntMessage);
        return new SuccessDataResult<CntMessageDto>(cntMessageDto,"Sms Gönderildi");
    }

    @Override
    public Result delete(Long id) {
        CntMessage cntMessage = getCntMessage(id);
        cntMessageEntityService.delete(cntMessage);
        log.info("Deleted sms {}", cntMessage);
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
