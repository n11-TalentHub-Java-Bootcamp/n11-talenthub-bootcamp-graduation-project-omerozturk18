package com.omerozturk.N11GraduationProject.csr.services.concretes;

import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrGuarantee;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrGuaranteeDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrGuaranteeSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.entities.enums.GuaranteeType;
import com.omerozturk.N11GraduationProject.csr.utilities.converter.CsrGuaranteeMapper;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessDataResult;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CsrGuaranteeServiceImplDataProvider {
    public static DataResult<List<CsrGuaranteeDto>> convertToDtoList(List<CsrGuarantee> csrGuaranteeList) {
        List<CsrGuaranteeDto> csrGuaranteeDtoList = CsrGuaranteeMapper.INSTANCE.
                convertCsrGuaranteeListToCsrGuaranteeDtoList(csrGuaranteeList);
        DataResult<List<CsrGuaranteeDto>> dataResultCsrGuaranteeDtoList = new SuccessDataResult<List<CsrGuaranteeDto>>(csrGuaranteeDtoList);
        return dataResultCsrGuaranteeDtoList;
    }
    public static DataResult<CsrGuaranteeDto> convertToDto(CsrGuarantee csrGuarantee) {
        CsrGuaranteeDto csrGuaranteeDto = CsrGuaranteeMapper.INSTANCE.
                convertCsrGuaranteeToCsrGuaranteeDto(csrGuarantee);
        DataResult<CsrGuaranteeDto> csrGuaranteeDtoSuccessDataResult = new SuccessDataResult<>(csrGuaranteeDto);
        return csrGuaranteeDtoSuccessDataResult;
    }
    public static CsrGuarantee convertToSaveRequestDto(CsrGuaranteeSaveRequestDto csrGuaranteeSaveRequestDto) {
        CsrGuarantee csrGuarantee = CsrGuaranteeMapper.INSTANCE.
                convertCsrGuaranteeSaveRequestDtoToCsrGuarantee(csrGuaranteeSaveRequestDto);
        return csrGuarantee;
    }

    public static List<CsrGuarantee> getAllGuaranteeList() {
        List<CsrGuarantee> csrGuaranteeList=new ArrayList<>();

        for(long i=1;i<=10;i++){
            CsrGuarantee csrGuarantee=new CsrGuarantee();

            csrGuarantee.setId(i);
            csrGuarantee.setExplanation("Credit Guarantee");
            csrGuarantee.setGuaranteeType(GuaranteeType.GOLD);
            csrGuarantee.setCsrCustomerId(i);
            csrGuarantee.setOperationDate(new Date());
            csrGuaranteeList.add(csrGuarantee);
        }
        return csrGuaranteeList;
    }
    public  static CsrGuaranteeSaveRequestDto getCsrGuaranteeSaveRequest(){
        CsrGuaranteeSaveRequestDto csrGuaranteeSaveRequestDto=new CsrGuaranteeSaveRequestDto();
        csrGuaranteeSaveRequestDto.setExplanation("Credit Guarantee");
        csrGuaranteeSaveRequestDto.setGuaranteeType(GuaranteeType.GOLD);
        csrGuaranteeSaveRequestDto.setCsrCustomerId(1L);
        return  csrGuaranteeSaveRequestDto;
    }
    public static CsrGuarantee getCsrGuaranteeById(Long id) {
        List<CsrGuarantee> csrGuaranteeList = getAllGuaranteeList();
                Optional<CsrGuarantee> csrGuarantee = csrGuaranteeList.stream().filter(c -> c.getId().equals(id)).findFirst();
        return csrGuarantee.get();
    }

   public static List<CsrGuarantee> getCsrGuaranteeByCustomerId(Long customerId) {
        List<CsrGuarantee> csrGuaranteeList = getAllGuaranteeList();
       csrGuaranteeList = csrGuaranteeList.stream().filter(c -> c.getCsrCustomerId().equals(customerId)).collect(Collectors.toList());
        return csrGuaranteeList;
    }
}
