package com.omerozturk.N11GraduationProject.cnt.services.concretes;

import com.omerozturk.N11GraduationProject.cnt.entities.concretes.CntMessage;
import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageDto;
import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageSendRequestDto;
import com.omerozturk.N11GraduationProject.cnt.services.entityservice.CntMessageEntityService;
import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomer;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerDto;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerService;
import com.omerozturk.N11GraduationProject.csr.services.concretes.CsrCustomerServiceImplDataProvider;
import com.omerozturk.N11GraduationProject.gen.adapter.twilioAdapter.TwilioService;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CntMessageServiceImplTest {

    @Mock
    private CntMessageEntityService cntMessageEntityService;
    @Mock
    private CsrCustomerService csrCustomerService;
    @Mock
    private TwilioService twilioService;

    @InjectMocks
    private CntMessageServiceImpl cntMessageService;
    
    @Test
    void findAll() {
          List<CntMessage> cntMessageList = CntMessageServiceImplDataProvider.getAllMessageList();

        when(cntMessageEntityService.findAll()).thenReturn(cntMessageList);

        DataResult<List<CntMessageDto>> dataResultCntMessageDtoList = CntMessageServiceImplDataProvider.convertToDtoList(cntMessageList);

        DataResult<List<CntMessageDto>> result = cntMessageService.findAll();

        assertArrayEquals(dataResultCntMessageDtoList.getData().toArray(), result.getData().toArray());

    }

    @Test
    void findById() {

        CntMessage cntMessage = CntMessageServiceImplDataProvider.getCntMessageById(1L);

        when(cntMessageEntityService.findById(1L)).thenReturn(cntMessage);

        DataResult<CntMessageDto> dataResultCntMessageDto = CntMessageServiceImplDataProvider.convertToDto(cntMessage);

        DataResult<CntMessageDto> result = cntMessageService.findById(1L);

        assertEquals(dataResultCntMessageDto.getData(),result.getData());

    }

    @Test
    void sendMessage() {

         CntMessageSendRequestDto cntMessageSaveRequestDto= CntMessageServiceImplDataProvider.getCntMessageSendRequest();
        CntMessage cntMessage = CntMessageServiceImplDataProvider.convertToSendDto(cntMessageSaveRequestDto);

        CsrCustomer csrCustomer= CsrCustomerServiceImplDataProvider.getCsrCustomerById(1L);
        DataResult<CsrCustomerDto> customerDtoDataResult = CsrCustomerServiceImplDataProvider.convertToDto(csrCustomer);
        when(csrCustomerService.findById(1L)).thenReturn(customerDtoDataResult);

        when(cntMessageEntityService.save(ArgumentMatchers.any(CntMessage.class))).thenReturn(cntMessage);
        DataResult<CntMessageDto> cntMessageDtoDataResult = CntMessageServiceImplDataProvider.convertToDto(cntMessage);

        DataResult<CntMessageDto> result = cntMessageService.sendMessage(cntMessageSaveRequestDto);

        assertEquals(cntMessageDtoDataResult.getData(),result.getData() );

    }

    @Test
    void delete() {

        CntMessage cntMessage = CntMessageServiceImplDataProvider.getCntMessageById(1L);
        when(cntMessageEntityService.findById(1L)).thenReturn(cntMessage);

        Result result = cntMessageService.delete(1L);

        assertEquals(new Result(true).isSuccess(),result.isSuccess() );
        
    }
}