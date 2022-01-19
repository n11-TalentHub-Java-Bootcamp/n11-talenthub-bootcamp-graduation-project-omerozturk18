package com.omerozturk.N11GraduationProject.sms.services.concretes;


import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessDataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessResult;
import com.omerozturk.N11GraduationProject.sms.entities.concretes.CntSms;
import com.omerozturk.N11GraduationProject.sms.entities.dtos.CntSmsDto;
import com.omerozturk.N11GraduationProject.sms.entities.dtos.CntSmsSaveRequestDto;
import com.omerozturk.N11GraduationProject.sms.services.abstracts.CntSmsService;
import com.omerozturk.N11GraduationProject.sms.services.entityservice.CntSmsEntityService;
import com.omerozturk.N11GraduationProject.sms.utilities.converter.CntSmsMapper;
import com.omerozturk.N11GraduationProject.sms.utilities.exception.CntSmsNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CntSmsManager implements CntSmsService {

    private final CntSmsEntityService cntSmsEntityService;

    @Override
    public DataResult<List<CntSmsDto>> findAll() {
        List<CntSms> cntSmsList = cntSmsEntityService.findAll();
        List<CntSmsDto> cntSmsDtoList = CntSmsMapper.INSTANCE.convertCntSmsListToCntSmsDtoList(cntSmsList);
        return new SuccessDataResult<List<CntSmsDto>>(cntSmsDtoList,"Veriler Listelendi");
    }

    @Override
    public DataResult<CntSmsDto> findById(Long id) {
        CntSms cntSms = getCntSms(id);
        CntSmsDto cntSmsDto = CntSmsMapper.INSTANCE.convertCntSmsToCntSmsDto(cntSms);
        return new SuccessDataResult<CntSmsDto>(cntSmsDto,"Kullanıcı Getirildi");
    }



    @Override
    public DataResult<CntSmsDto> save(CntSmsSaveRequestDto cntSmsSaveRequestDto) {
        CntSms cntSms = CntSmsMapper.INSTANCE.convertCntSmsSaveRequestDtoToCntSms(cntSmsSaveRequestDto);
        cntSms = cntSmsEntityService.save(cntSms);
        CntSmsDto cntSmsDto = CntSmsMapper.INSTANCE.convertCntSmsToCntSmsDto(cntSms);
        return new SuccessDataResult<CntSmsDto>(cntSmsDto,"Kullanıcı Eklendi");
    }

    @Override
    public Result delete(Long id) {
        CntSms cntSms = getCntSms(id);
        cntSmsEntityService.delete(cntSms);
        return new SuccessResult(" Kullanıcı Silindi");
    }

    private CntSms getCntSms(Long id){
        CntSms cntSms = cntSmsEntityService.findById(id);
        if (cntSms == null){
            throw new CntSmsNotFoundException("Kullanıcı Bulunanamdı!");
        }
        return cntSms;
    }

}
