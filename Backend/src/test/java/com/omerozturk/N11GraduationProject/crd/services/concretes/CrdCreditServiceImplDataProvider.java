package com.omerozturk.N11GraduationProject.crd.services.concretes;

import com.omerozturk.N11GraduationProject.crd.entities.concretes.CrdCredit;
import com.omerozturk.N11GraduationProject.crd.entities.dtos.CrdCreditDto;
import com.omerozturk.N11GraduationProject.crd.entities.dtos.CrdCreditSaveRequestDto;
import com.omerozturk.N11GraduationProject.crd.utilities.converter.CrdCreditMapper;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessDataResult;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CrdCreditServiceImplDataProvider {
    public static DataResult<List<CrdCreditDto>> convertToDtoList(List<CrdCredit> crdCreditList) {
        List<CrdCreditDto> crdCreditDtoList = CrdCreditMapper.INSTANCE.
                convertCrdCreditListToCrdCreditDtoList(crdCreditList);
        DataResult<List<CrdCreditDto>> dataResultCrdCreditDtoList = new SuccessDataResult<List<CrdCreditDto>>(crdCreditDtoList);
        return dataResultCrdCreditDtoList;
    }
    public static DataResult<CrdCreditDto> convertToDto(CrdCredit crdCredit) {
        CrdCreditDto crdCreditDto = CrdCreditMapper.INSTANCE.
                convertCrdCreditToCrdCreditDto(crdCredit);
        DataResult<CrdCreditDto> crdCreditDtoSuccessDataResult = new SuccessDataResult<>(crdCreditDto);
        return crdCreditDtoSuccessDataResult;
    }
    public static CrdCredit convertToSaveRequestDto(CrdCreditSaveRequestDto crdCreditSaveRequestDto) {
        CrdCredit crdCredit = CrdCreditMapper.INSTANCE.
                convertCrdCreditSaveRequestDtoToCrdCredit(crdCreditSaveRequestDto);
        return crdCredit;
    }

    public static List<CrdCredit> getAllCreditList() {
        List<CrdCredit> crdCreditList=new ArrayList<>();
        for(long i=1;i<=10;i++){
            CrdCredit crdCredit=new CrdCredit();
            crdCredit.setId(i);
            crdCredit.setName("Name " + i);
            crdCredit.setShortName("Short Name " + i);
            crdCredit.setExplanation("Explanation " + i);
            crdCredit.setOperationDate(new Date());
            crdCredit.setStatus(i==10L?EnumStatus.DELETED:EnumStatus.ACTIVE);

            crdCreditList.add(crdCredit);
        }
        return crdCreditList;
    }
    public  static CrdCreditSaveRequestDto getCrdCreditSaveRequest(){
        CrdCreditSaveRequestDto crdCreditSaveRequestDto=new CrdCreditSaveRequestDto();
        crdCreditSaveRequestDto.setName("Name");
        crdCreditSaveRequestDto.setShortName("Short Name");
        crdCreditSaveRequestDto.setExplanation("Explanation");
        return  crdCreditSaveRequestDto;
    }
    public static CrdCredit getCrdCreditById(Long id) {
        List<CrdCredit> crdCreditList = getAllCreditList();
                Optional<CrdCredit> crdCredit = crdCreditList.stream().filter(c -> c.getId().equals(id)).findFirst();
        return crdCredit.get();
    }

    public static CrdCredit getCrdCreditByCreditName(String creditName) {
        List<CrdCredit> crdCreditList = getAllCreditList();
        Optional<CrdCredit> crdCredit = crdCreditList.stream().filter(c -> c.getName().equals(creditName)).findFirst();
        return crdCredit.get();
    }


}
