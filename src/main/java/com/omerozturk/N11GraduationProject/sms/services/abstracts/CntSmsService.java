package com.omerozturk.N11GraduationProject.sms.services.abstracts;

import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;
import com.omerozturk.N11GraduationProject.sms.entities.dtos.CntSmsDto;
import com.omerozturk.N11GraduationProject.sms.entities.dtos.CntSmsSaveRequestDto;

import java.util.List;

public interface CntSmsService {
    DataResult<List<CntSmsDto>> findAll();
    DataResult<CntSmsDto> findById(Long id);
    DataResult<CntSmsDto> save(CntSmsSaveRequestDto cntSmsSaveRequestDto);
    Result delete(Long id);
}
