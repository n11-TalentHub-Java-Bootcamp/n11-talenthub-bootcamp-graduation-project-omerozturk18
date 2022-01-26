package com.omerozturk.N11GraduationProject.crd.services.concretes;

import com.omerozturk.N11GraduationProject.crd.entities.concretes.CrdCredit;
import com.omerozturk.N11GraduationProject.crd.entities.dtos.CrdCreditDto;
import com.omerozturk.N11GraduationProject.crd.entities.dtos.CrdCreditSaveRequestDto;
import com.omerozturk.N11GraduationProject.crd.services.entityservice.CrdCreditEntityService;
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
class CrdCreditServiceImplTest {

    @Mock
    private CrdCreditEntityService crdCreditEntityService;
    
    @InjectMocks
    private CrdCreditServiceImpl crdCreditService;
    @Test
    void findAll() {

         List<CrdCredit> crdCreditList = CrdCreditServiceImplDataProvider.getAllCreditList();

        when(crdCreditEntityService.findAll()).thenReturn(crdCreditList);

        DataResult<List<CrdCreditDto>> dataResultCrdCreditDtoList = CrdCreditServiceImplDataProvider.convertToDtoList(crdCreditList);

        DataResult<List<CrdCreditDto>> result = crdCreditService.findAll();

        assertArrayEquals(dataResultCrdCreditDtoList.getData().toArray(), result.getData().toArray());

    }

    @Test
    void findById() {

        CrdCredit crdCredit = CrdCreditServiceImplDataProvider.getCrdCreditById(1L);

        when(crdCreditEntityService.findById(1L)).thenReturn(crdCredit);

        DataResult<CrdCreditDto> dataResultCrdCreditDto = CrdCreditServiceImplDataProvider.convertToDto(crdCredit);

        DataResult<CrdCreditDto> result = crdCreditService.findById(1L);

        assertEquals(dataResultCrdCreditDto.getData(),result.getData());

    }

    @Test
    void findByCreditName() {

        CrdCredit crdCredit = CrdCreditServiceImplDataProvider.getCrdCreditByCreditName("Name 1");
        when(crdCreditEntityService.findByCreditName("Name 1")).thenReturn(crdCredit);

        DataResult<CrdCreditDto> dataResultCrdCreditDto = CrdCreditServiceImplDataProvider.convertToDto(crdCredit);
        DataResult<CrdCreditDto> result = crdCreditService.findByCreditName("Name 1");

        assertEquals(dataResultCrdCreditDto.getData(),result.getData());

    }

    @Test
    void save() {

         CrdCreditSaveRequestDto crdCreditSaveRequestDto= CrdCreditServiceImplDataProvider.getCrdCreditSaveRequest();
        CrdCredit crdCredit = CrdCreditServiceImplDataProvider.convertToSaveRequestDto(crdCreditSaveRequestDto);
        
        when(crdCreditEntityService.save(ArgumentMatchers.any(CrdCredit.class))).thenReturn(crdCredit);
        DataResult<CrdCreditDto> customerDtoDataResult = CrdCreditServiceImplDataProvider.convertToDto(crdCredit);

        DataResult<CrdCreditDto> result = crdCreditService.save(crdCreditSaveRequestDto);

        assertEquals(customerDtoDataResult.getData(),result.getData() );

    }

    @Test
    void delete() {

        CrdCredit crdCredit= CrdCreditServiceImplDataProvider.getCrdCreditById(1L);
        when(crdCreditEntityService.findById(1L)).thenReturn(crdCredit);

        when(crdCreditEntityService.save(ArgumentMatchers.any(CrdCredit.class))).thenReturn(crdCredit);

        Result result = crdCreditService.delete(1L);

        assertEquals(new Result(true).isSuccess(),result.isSuccess() );

    }
}