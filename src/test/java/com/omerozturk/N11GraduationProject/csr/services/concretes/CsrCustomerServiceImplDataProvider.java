package com.omerozturk.N11GraduationProject.csr.services.concretes;

import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomer;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.entities.enums.EnumCreditResult;
import com.omerozturk.N11GraduationProject.csr.utilities.converter.CsrCustomerMapper;
import com.omerozturk.N11GraduationProject.gen.utilities.enums.EnumStatus;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessDataResult;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CsrCustomerServiceImplDataProvider {
    public static DataResult<List<CsrCustomerDto>> convertToDtoList(List<CsrCustomer> csrCustomerList) {
        List<CsrCustomerDto> csrCustomerDtoList = CsrCustomerMapper.INSTANCE.
                convertCsrCustomerListToCsrCustomerDtoList(csrCustomerList);
        DataResult<List<CsrCustomerDto>> dataResultCsrCustomerDtoList = new SuccessDataResult<List<CsrCustomerDto>>(csrCustomerDtoList);
        return dataResultCsrCustomerDtoList;
    }
    public static DataResult<CsrCustomerDto> convertToDto(CsrCustomer csrCustomer) {
        CsrCustomerDto csrCustomerDto = CsrCustomerMapper.INSTANCE.
                convertCsrCustomerToCsrCustomerDto(csrCustomer);
        DataResult<CsrCustomerDto> csrCustomerDtoSuccessDataResult = new SuccessDataResult<>(csrCustomerDto);
        return csrCustomerDtoSuccessDataResult;
    }
    public static CsrCustomer convertToSaveRequestDto(CsrCustomerSaveRequestDto csrCustomerSaveRequestDto) {
        CsrCustomer csrCustomer = CsrCustomerMapper.INSTANCE.
                convertCsrCustomerSaveRequestDtoToCsrCustomer(csrCustomerSaveRequestDto);
        return csrCustomer;
    }

    public static List<CsrCustomer> getAllCustomerList() {
        List<CsrCustomer> csrCustomerList=new ArrayList<>();
        String identityNumber="";
        for(long i=1;i<=10;i++){
            if(i % 2 != 0 ){
                identityNumber = "1234567891" + (i+1);
            }else{
                identityNumber = "1234567891" + i;
            }
            CsrCustomer csrCustomer=new CsrCustomer();
            csrCustomer.setId(i);
            csrCustomer.setIdentityNumber(identityNumber);
            csrCustomer.setFirstName("FirstName " + i);
            csrCustomer.setLastName("LastName " + i);
            csrCustomer.setDateOfBirth(new Date());
            csrCustomer.setPhoneNumber("1234567891" + i);
            csrCustomer.setSalary(new BigDecimal(i*1000));
            csrCustomer.setOperationDate(new Date());
            csrCustomer.setStatus(i==10L?EnumStatus.DELETED:EnumStatus.ACTIVE);

            csrCustomerList.add(csrCustomer);
        }
        return csrCustomerList;
    }
    public  static CsrCustomerSaveRequestDto getCsrCustomerSaveRequest(){
        CsrCustomerSaveRequestDto csrCustomerSaveRequestDto=new CsrCustomerSaveRequestDto();
        csrCustomerSaveRequestDto.setIdentityNumber("12345678910");
        csrCustomerSaveRequestDto.setFirstName("FirstName ");
        csrCustomerSaveRequestDto.setLastName("LastName ");
        csrCustomerSaveRequestDto.setDateOfBirth(new Date());
        csrCustomerSaveRequestDto.setPhoneNumber("12345678910");
        csrCustomerSaveRequestDto.setSalary(new BigDecimal(10000));
        return  csrCustomerSaveRequestDto;
    }
    public static CsrCustomer getCsrCustomerById(Long id) {
        List<CsrCustomer> csrCustomerList = getAllCustomerList();
                Optional<CsrCustomer> csrCustomer = csrCustomerList.stream().filter(c -> c.getId().equals(id)).findFirst();
        return csrCustomer.get();
    }

    public static CsrCustomer getCsrCustomerByIdentityNumber(String identityNumber) {
        List<CsrCustomer> csrCustomerList = getAllCustomerList();
        Optional<CsrCustomer> csrCustomer = csrCustomerList.stream().filter(c -> c.getIdentityNumber().equals(identityNumber)).findFirst();
        return csrCustomer.get();
    }
}
