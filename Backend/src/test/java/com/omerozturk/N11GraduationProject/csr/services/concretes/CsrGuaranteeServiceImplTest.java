package com.omerozturk.N11GraduationProject.csr.services.concretes;

import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrGuarantee;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrGuaranteeDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrGuaranteeSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerService;
import com.omerozturk.N11GraduationProject.csr.services.entityservice.CsrGuaranteeEntityService;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CsrGuaranteeServiceImplTest {

    @Mock
    private CsrGuaranteeEntityService csrGuaranteeEntityService;
    @Mock
    private CsrCustomerService csrCustomerService;

    @InjectMocks
    private CsrGuaranteeServiceImpl csrGuaranteeService;

    @Test
    void findAll() {
        
        List<CsrGuarantee> csrGuaranteeList = CsrGuaranteeServiceImplDataProvider.getAllGuaranteeList();

        when(csrGuaranteeEntityService.findAll()).thenReturn(csrGuaranteeList);

        DataResult<List<CsrGuaranteeDto>> dataResultCsrGuaranteeDtoList = CsrGuaranteeServiceImplDataProvider.convertToDtoList(csrGuaranteeList);

        DataResult<List<CsrGuaranteeDto>> result = csrGuaranteeService.findAll();

        assertArrayEquals(dataResultCsrGuaranteeDtoList.getData().toArray(), result.getData().toArray());

    }

    @Test
    void findById() {

        CsrGuarantee csrGuarantee = CsrGuaranteeServiceImplDataProvider.getCsrGuaranteeById(1L);

        when(csrGuaranteeEntityService.findById(1L)).thenReturn(csrGuarantee);

        DataResult<CsrGuaranteeDto> dataResultCsrGuaranteeDto = CsrGuaranteeServiceImplDataProvider.convertToDto(csrGuarantee);

        DataResult<CsrGuaranteeDto> result = csrGuaranteeService.findById(1L);

        assertEquals(dataResultCsrGuaranteeDto.getData(),result.getData());

    }

    @Test
    void findByCustomerId() {

        List<CsrGuarantee> csrGuaranteeList = CsrGuaranteeServiceImplDataProvider.getCsrGuaranteeByCustomerId(1L);

        when(csrGuaranteeEntityService.findByCustomerId(1L)).thenReturn(csrGuaranteeList);

        DataResult<List<CsrGuaranteeDto>> dataResultCsrGuaranteeDtoList = CsrGuaranteeServiceImplDataProvider.convertToDtoList(csrGuaranteeList);

        DataResult<List<CsrGuaranteeDto>> result = csrGuaranteeService.findByCustomerId(1L);

        assertEquals(dataResultCsrGuaranteeDtoList.getData(),result.getData());
    }
    
    @Test
    void save() {

        CsrGuaranteeSaveRequestDto csrGuaranteeSaveRequestDto= CsrGuaranteeServiceImplDataProvider.getCsrGuaranteeSaveRequest();
        CsrGuarantee csrGuarantee = CsrGuaranteeServiceImplDataProvider.convertToSaveRequestDto(csrGuaranteeSaveRequestDto);
        
        when(csrGuaranteeEntityService.save(ArgumentMatchers.any(CsrGuarantee.class))).thenReturn(csrGuarantee);
        DataResult<CsrGuaranteeDto> customerDtoDataResult = CsrGuaranteeServiceImplDataProvider.convertToDto(csrGuarantee);

        DataResult<CsrGuaranteeDto> result = csrGuaranteeService.save(csrGuaranteeSaveRequestDto);

        assertEquals(customerDtoDataResult.getData(),result.getData() );

    }

    @Test
    void delete() {

        CsrGuarantee csrGuarantee= CsrGuaranteeServiceImplDataProvider.getCsrGuaranteeById(1L);
        when(csrGuaranteeEntityService.findById(1L)).thenReturn(csrGuarantee);

        Result result = csrGuaranteeService.delete(1L);

        assertEquals(new Result(true).isSuccess(),result.isSuccess() );

    }
}