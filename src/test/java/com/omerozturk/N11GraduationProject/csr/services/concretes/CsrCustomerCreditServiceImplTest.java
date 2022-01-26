package com.omerozturk.N11GraduationProject.csr.services.concretes;

import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageSendRequestDto;
import com.omerozturk.N11GraduationProject.cnt.services.abstracts.CntMessageService;
import com.omerozturk.N11GraduationProject.crd.entities.concretes.CrdCredit;
import com.omerozturk.N11GraduationProject.crd.entities.dtos.CrdCreditDto;
import com.omerozturk.N11GraduationProject.crd.services.abstracts.CrdCreditService;
import com.omerozturk.N11GraduationProject.crd.services.concretes.CrdCreditServiceImplDataProvider;
import com.omerozturk.N11GraduationProject.crd.utilities.exception.CrdCreditNotFoundException;
import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomer;
import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomerCredit;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditResponseDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerDto;
import com.omerozturk.N11GraduationProject.csr.entities.enums.EnumCreditResult;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerService;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrGuaranteeService;
import com.omerozturk.N11GraduationProject.csr.services.entityservice.CsrCustomerCreditEntityService;
import com.omerozturk.N11GraduationProject.csr.utilities.exception.CsrCustomerCreditNotFoundException;
import com.omerozturk.N11GraduationProject.csr.utilities.exception.CsrCustomerNotFoundException;
import com.omerozturk.N11GraduationProject.gen.adapter.creditScoreAdapter.CustomerCreditScoreService;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.ErrorDataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.SuccessDataResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CsrCustomerCreditServiceImplTest {

    @Mock
    private CsrCustomerCreditEntityService csrCustomerCreditEntityService;
    @Mock
    private CsrCustomerService csrCustomerService;
    @Mock
    private CrdCreditService crdCreditService;
    @Mock
    private CntMessageService cntMessageService;
    @Mock
    private CustomerCreditScoreService customerCreditScoreService;
    @Mock
    private CsrGuaranteeService csrGuaranteeService;
    @InjectMocks
    private CsrCustomerCreditServiceImpl csrCustomerCreditService;

    @Test
    void findAll() {

        List<CsrCustomerCredit> csrCustomerCreditList = CsrCustomerCreditServiceImplDataProvider.getAllCustomerCreditList();

        when(csrCustomerCreditEntityService.findAll()).thenReturn(csrCustomerCreditList);

        DataResult<List<CsrCustomerCreditDto>> dataResultCsrCustomerCreditDtoList = CsrCustomerCreditServiceImplDataProvider.convertToDtoList(csrCustomerCreditList);

        DataResult<List<CsrCustomerCreditDto>> result = csrCustomerCreditService.findAll();

        assertArrayEquals(dataResultCsrCustomerCreditDtoList.getData().toArray(), result.getData().toArray());
    }


    @Test
    void findById() {
        CsrCustomerCredit csrCustomerCredit = CsrCustomerCreditServiceImplDataProvider.getCsrCustomerCreditById(1L);

        when(csrCustomerCreditEntityService.findById(1L)).thenReturn(csrCustomerCredit);

        DataResult<CsrCustomerCreditDto> dataResultCsrCustomerCreditDto = CsrCustomerCreditServiceImplDataProvider.convertToDto(csrCustomerCredit);

        DataResult<CsrCustomerCreditDto> result = csrCustomerCreditService.findById(1L);

        assertEquals(dataResultCsrCustomerCreditDto.getData(),result.getData());
    }

    @Test
    void findById_customerCreditNotFound() {
        Exception exception = assertThrows(Exception.class, () -> csrCustomerCreditService.findById(11L));
        assertEquals(CsrCustomerCreditNotFoundException.class, exception.getClass());
    }

    @Test
    void findById_customerCreditNotActive() {
        CsrCustomerCredit csrCustomerCredit = CsrCustomerCreditServiceImplDataProvider.getCsrCustomerCreditById(10L);

        when(csrCustomerCreditEntityService.findById(10L)).thenReturn(csrCustomerCredit);

        Exception exception = assertThrows(Exception.class, () -> csrCustomerCreditService.findById(10L));
        assertEquals(CsrCustomerCreditNotFoundException.class, exception.getClass());
    }

    @Test
    void findByCustomerId() {
        List<CsrCustomerCredit> csrCustomerCreditList= CsrCustomerCreditServiceImplDataProvider.getCsrCustomerCreditsByCustomerId(1L);

        when(csrCustomerCreditEntityService.findByCustomerId(1L)).thenReturn(csrCustomerCreditList);

        DataResult<List<CsrCustomerCreditDto>> dataResultCsrCustomerCreditDtoList = CsrCustomerCreditServiceImplDataProvider.convertToDtoList(csrCustomerCreditList);

        DataResult<List<CsrCustomerCreditDto>> result = csrCustomerCreditService.findByCustomerId(1L);

        assertEquals(dataResultCsrCustomerCreditDtoList.getData(),result.getData());

    }
    @Test
    void findByCustomerId_customerCreditNull() {
        Exception exception = assertThrows(Exception.class, () -> csrCustomerCreditService.findByCustomerId(1L));
        assertEquals(CsrCustomerCreditNotFoundException.class, exception.getClass());
    }

    @Test
    void findActiveCreditsByCustomerId() {
        List<CsrCustomerCredit> csrCustomerCreditList= CsrCustomerCreditServiceImplDataProvider.getCsrCustomerCreditsByCustomerId(1L);

        when(csrCustomerCreditEntityService.findActiveCreditsByCustomerId(1L)).thenReturn(csrCustomerCreditList);

        DataResult<List<CsrCustomerCreditDto>> dataResultCsrCustomerCreditDtoList = CsrCustomerCreditServiceImplDataProvider.convertToDtoList(csrCustomerCreditList);

        DataResult<List<CsrCustomerCreditDto>> result = csrCustomerCreditService.findActiveCreditsByCustomerId(1L);

        assertEquals(dataResultCsrCustomerCreditDtoList.getData(),result.getData());
    }

    @Test
    void findByCreditId() {
        List<CsrCustomerCredit> csrCustomerCreditList= CsrCustomerCreditServiceImplDataProvider.getCsrCustomerCreditsByCreditId(1L);

        when(csrCustomerCreditEntityService.findByCreditId(1L)).thenReturn(csrCustomerCreditList);

        DataResult<List<CsrCustomerCreditDto>> dataResultCsrCustomerCreditDtoList = CsrCustomerCreditServiceImplDataProvider.convertToDtoList(csrCustomerCreditList);

        DataResult<List<CsrCustomerCreditDto>> result = csrCustomerCreditService.findByCreditId(1L);

        assertEquals(dataResultCsrCustomerCreditDtoList.getData(),result.getData());
    }

    @Test
    void applyForCredit_deniedResult() {

        CsrCustomerCreditSaveRequestDto csrCustomerCreditSaveRequestDto= CsrCustomerCreditServiceImplDataProvider.getCsrCustomerCreditSaveRequest();

        CsrCustomer csrCustomer= CsrCustomerServiceImplDataProvider.getCsrCustomerById(1L);
        DataResult<CsrCustomerDto> customerDtoDataResult = CsrCustomerServiceImplDataProvider.convertToDto(csrCustomer);
        when(csrCustomerService.findById(1L)).thenReturn(customerDtoDataResult);

        CrdCredit crdCredit= CrdCreditServiceImplDataProvider.getCrdCreditById(1L);
        DataResult<CrdCreditDto> creditDtoDataResult = CrdCreditServiceImplDataProvider.convertToDto(crdCredit);
        when(crdCreditService.findById(1L)).thenReturn(creditDtoDataResult);

        CsrCustomerCredit csrCustomerCreditSaved= CsrCustomerCreditServiceImplDataProvider.getDeniedCsrCustomerCredit();
        DataResult<CsrCustomerCreditDto> csrCustomerCreditDtoDataResult = CsrCustomerCreditServiceImplDataProvider.convertToDto(csrCustomerCreditSaved);

        when(csrCustomerCreditEntityService.save(ArgumentMatchers.any(CsrCustomerCredit.class))).thenReturn(csrCustomerCreditSaved);

        DataResult<CsrCustomerCreditDto> result = csrCustomerCreditService.applyForCredit(csrCustomerCreditSaveRequestDto);

        assertEquals(csrCustomerCreditDtoDataResult.getData(),result.getData() );
    }

    @Test
    void applyForCredit_approvedResult() {

        CsrCustomerCreditSaveRequestDto csrCustomerCreditSaveRequestDto= CsrCustomerCreditServiceImplDataProvider.getCsrCustomerCreditSaveRequest();

        CsrCustomer csrCustomer= CsrCustomerServiceImplDataProvider.getCsrCustomerById(1L);
        DataResult<CsrCustomerDto> customerDtoDataResult = CsrCustomerServiceImplDataProvider.convertToDto(csrCustomer);
        when(csrCustomerService.findById(1L)).thenReturn(customerDtoDataResult);

        CrdCredit crdCredit= CrdCreditServiceImplDataProvider.getCrdCreditById(1L);
        DataResult<CrdCreditDto> creditDtoDataResult = CrdCreditServiceImplDataProvider.convertToDto(crdCredit);
        when(crdCreditService.findById(1L)).thenReturn(creditDtoDataResult);

        when(cntMessageService.sendMessage(ArgumentMatchers.any(CntMessageSendRequestDto.class))).thenReturn(new SuccessDataResult<>());

        CsrCustomerCredit csrCustomerCreditSaved= CsrCustomerCreditServiceImplDataProvider.getApprovedCsrCustomerCredit();
        DataResult<CsrCustomerCreditDto> csrCustomerCreditDtoDataResult = CsrCustomerCreditServiceImplDataProvider.convertToDto(csrCustomerCreditSaved);

        when(csrCustomerCreditEntityService.save(ArgumentMatchers.any(CsrCustomerCredit.class))).thenReturn(csrCustomerCreditSaved);

        DataResult<CsrCustomerCreditDto> result = csrCustomerCreditService.applyForCredit(csrCustomerCreditSaveRequestDto);

        assertEquals(csrCustomerCreditDtoDataResult.getData(),result.getData() );
    }

    @Test
    void applyForCredit_customerNotFound() {

        CsrCustomerCreditSaveRequestDto csrCustomerCreditSaveRequestDto= CsrCustomerCreditServiceImplDataProvider.getCsrCustomerCreditSaveRequest();
        when(csrCustomerService.findById(ArgumentMatchers.any())).thenThrow(CsrCustomerNotFoundException.class);
        Exception exception = assertThrows(Exception.class, () -> csrCustomerCreditService.applyForCredit(csrCustomerCreditSaveRequestDto));
        assertEquals(CsrCustomerNotFoundException.class, exception.getClass());
    }

    @Test
    void applyForCredit_creditNotFound() {

        CsrCustomerCreditSaveRequestDto csrCustomerCreditSaveRequestDto= CsrCustomerCreditServiceImplDataProvider.getCsrCustomerCreditSaveRequest();

        CsrCustomer csrCustomer= CsrCustomerServiceImplDataProvider.getCsrCustomerById(1L);
        DataResult<CsrCustomerDto> customerDtoDataResult = CsrCustomerServiceImplDataProvider.convertToDto(csrCustomer);
        when(csrCustomerService.findById(1L)).thenReturn(customerDtoDataResult);


        when(crdCreditService.findById(ArgumentMatchers.any())).thenThrow(CrdCreditNotFoundException.class);
        Exception exception = assertThrows(Exception.class, () -> csrCustomerCreditService.applyForCredit(csrCustomerCreditSaveRequestDto));

        assertEquals(CrdCreditNotFoundException.class, exception.getClass());
    }
    @Test
    void applyForCredit_haveSystemApprovedCredit() {

        CsrCustomerCreditSaveRequestDto csrCustomerCreditSaveRequestDto= CsrCustomerCreditServiceImplDataProvider.getCsrCustomerCreditSaveRequest();

        CsrCustomer csrCustomer= CsrCustomerServiceImplDataProvider.getCsrCustomerById(1L);
        DataResult<CsrCustomerDto> customerDtoDataResult = CsrCustomerServiceImplDataProvider.convertToDto(csrCustomer);
        when(csrCustomerService.findById(1L)).thenReturn(customerDtoDataResult);

        CsrCustomerCredit csrCustomerCredit=CsrCustomerCreditServiceImplDataProvider.getApprovedCsrCustomerCredit();
        when(csrCustomerCreditEntityService.findHaveSystemApprovedCreditByCustomerId(1L)).thenReturn(csrCustomerCredit);

        DataResult<CsrCustomerCreditDto> result = csrCustomerCreditService.applyForCredit(csrCustomerCreditSaveRequestDto);

        assertEquals(new SuccessDataResult("Zaten Onay Bekleyen Bir Krediniz Var").getMessage(),result.getMessage() );
    }


    @Test
    void customerCreditApprovedResponse() {
        CsrCustomerCreditResponseDto csrCustomerCreditResponseDto= CsrCustomerCreditServiceImplDataProvider.getCustomerCreditResponseDto(EnumCreditResult.CUSTOMER_APPROVED);

        CsrCustomerCredit csrCustomerCredit = CsrCustomerCreditServiceImplDataProvider.getApprovedCsrCustomerCredit();
        when(csrCustomerCreditEntityService.findById(1L)).thenReturn(csrCustomerCredit);


        CsrCustomerCredit csrCustomerCreditSaved= CsrCustomerCreditServiceImplDataProvider.getApprovedCsrCustomerCredit();
        csrCustomerCreditSaved.setCreditResult(EnumCreditResult.CUSTOMER_APPROVED);

        when(csrCustomerCreditEntityService.save(ArgumentMatchers.any(CsrCustomerCredit.class))).thenReturn(csrCustomerCreditSaved);

        DataResult<CsrCustomerCreditDto> result = csrCustomerCreditService.customerResponseCredit(csrCustomerCreditResponseDto);

        assertEquals(new SuccessDataResult<>().getClass(),result.getClass() );
        assertEquals(new SuccessDataResult<>("Kredinizi Onayladınız, Krediniz Hesabınıza Yatırılacaktır.").getMessage(),result.getMessage() );
    }

    @Test
    void customerCreditDeniedResponse() {
        CsrCustomerCreditResponseDto csrCustomerCreditResponseDto= CsrCustomerCreditServiceImplDataProvider.getCustomerCreditResponseDto(EnumCreditResult.CUSTOMER_DENIED);

        CsrCustomerCredit csrCustomerCredit = CsrCustomerCreditServiceImplDataProvider.getApprovedCsrCustomerCredit();
        when(csrCustomerCreditEntityService.findById(1L)).thenReturn(csrCustomerCredit);


        CsrCustomerCredit csrCustomerCreditSaved= CsrCustomerCreditServiceImplDataProvider.getApprovedCsrCustomerCredit();
        csrCustomerCreditSaved.setCreditResult(EnumCreditResult.CUSTOMER_DENIED);

        when(csrCustomerCreditEntityService.save(ArgumentMatchers.any(CsrCustomerCredit.class))).thenReturn(csrCustomerCreditSaved);

        DataResult<CsrCustomerCreditDto> result = csrCustomerCreditService.customerResponseCredit(csrCustomerCreditResponseDto);

        assertEquals(new ErrorDataResult<>().getClass(),result.getClass() );
        assertEquals(new ErrorDataResult<>("Krediyi Reddettiniz, Krediden Yararlanamayacaksınız.").getMessage(),result.getMessage() );
    }

    @Test
    void customerCreditResponse_systemDenied() {
        CsrCustomerCreditResponseDto csrCustomerCreditResponseDto= CsrCustomerCreditServiceImplDataProvider.getCustomerCreditResponseDto(EnumCreditResult.CUSTOMER_APPROVED);

        CsrCustomerCredit csrCustomerCredit = CsrCustomerCreditServiceImplDataProvider.getApprovedCsrCustomerCredit();
        csrCustomerCredit.setCreditResult(EnumCreditResult.SYSTEM_DENIED);
        when(csrCustomerCreditEntityService.findById(1L)).thenReturn(csrCustomerCredit);

        DataResult<CsrCustomerCreditDto> result = csrCustomerCreditService.customerResponseCredit(csrCustomerCreditResponseDto);

        assertEquals(new ErrorDataResult<>().getClass(),result.getClass() );
        assertEquals(new ErrorDataResult<>("Krediniz Onaylanmamıştır.").getMessage(),result.getMessage() );
    }
    @Test
    void customerCreditResponse_customerApproved() {
        CsrCustomerCreditResponseDto csrCustomerCreditResponseDto= CsrCustomerCreditServiceImplDataProvider.getCustomerCreditResponseDto(EnumCreditResult.CUSTOMER_APPROVED);

        CsrCustomerCredit csrCustomerCredit = CsrCustomerCreditServiceImplDataProvider.getApprovedCsrCustomerCredit();
        csrCustomerCredit.setCreditResult(EnumCreditResult.CUSTOMER_APPROVED);
        when(csrCustomerCreditEntityService.findById(1L)).thenReturn(csrCustomerCredit);

        DataResult<CsrCustomerCreditDto> result = csrCustomerCreditService.customerResponseCredit(csrCustomerCreditResponseDto);

        assertEquals(new ErrorDataResult<>().getClass(),result.getClass() );
        assertEquals(new ErrorDataResult<>("Bu Krediyi Zaten Cevapladınız.").getMessage(),result.getMessage() );
    }
}