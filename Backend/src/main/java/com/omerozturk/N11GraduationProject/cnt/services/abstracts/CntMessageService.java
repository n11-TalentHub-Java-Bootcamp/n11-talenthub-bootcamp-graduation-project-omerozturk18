package com.omerozturk.N11GraduationProject.cnt.services.abstracts;

import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;
import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageDto;
import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageSendRequestDto;

import java.util.List;

public interface CntMessageService {
    DataResult<List<CntMessageDto>> findAll();
    DataResult<CntMessageDto> findById(Long id);
    DataResult<List<CntMessageDto>> findByPhoneNumber(String phoneNumber);
    DataResult<CntMessageDto> sendMessage(CntMessageSendRequestDto cntMessageSendRequestDto);
    Result delete(Long id);
}
