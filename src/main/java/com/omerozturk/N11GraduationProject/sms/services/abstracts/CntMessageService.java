package com.omerozturk.N11GraduationProject.sms.services.abstracts;

import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;
import com.omerozturk.N11GraduationProject.sms.entities.dtos.CntMessageDto;
import com.omerozturk.N11GraduationProject.sms.entities.dtos.CntMessageSaveRequestDto;

import java.util.List;

public interface CntMessageService {
    DataResult<List<CntMessageDto>> findAll();
    DataResult<CntMessageDto> findById(Long id);
    DataResult<List<CntMessageDto>> findByPhoneNumber(String phoneNumber);
    DataResult<CntMessageDto> save(CntMessageSaveRequestDto cntSmsSaveRequestDto);
    Result delete(Long id);
}
