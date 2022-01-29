package com.omerozturk.N11GraduationProject.csr.services.concretes;

import com.omerozturk.N11GraduationProject.csr.entities.concretes.CsrCustomer;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.services.entityservice.CsrCustomerEntityService;
import com.omerozturk.N11GraduationProject.csr.utilities.exception.CsrCustomerNotCheckRealCustomerException;
import com.omerozturk.N11GraduationProject.csr.utilities.exception.CsrCustomerNotFoundException;
import com.omerozturk.N11GraduationProject.gen.adapter.mernisAdapter.CustomerCheckService;
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
class CsrCustomerServiceImplTest {

    @Mock
    private CsrCustomerEntityService csrCustomerEntityService;
    @Mock
    private CustomerCheckService customerCheckService;

    @InjectMocks
    private CsrCustomerServiceImpl csrCustomerService;

    @Test
    void findAll() {

        List<CsrCustomer> csrCustomerList = CsrCustomerServiceImplDataProvider.getAllCustomerList();

        when(csrCustomerEntityService.findAll()).thenReturn(csrCustomerList);

        DataResult<List<CsrCustomerDto>> dataResultCsrCustomerDtoList = CsrCustomerServiceImplDataProvider.convertToDtoList(csrCustomerList);

        DataResult<List<CsrCustomerDto>> result = csrCustomerService.findAll();

        assertArrayEquals(dataResultCsrCustomerDtoList.getData().toArray(), result.getData().toArray());
    }


    @Test
    void findById() {
        CsrCustomer csrCustomer = CsrCustomerServiceImplDataProvider.getCsrCustomerById(1L);

        when(csrCustomerEntityService.findById(1L)).thenReturn(csrCustomer);

        DataResult<CsrCustomerDto> dataResultCsrCustomerDto = CsrCustomerServiceImplDataProvider.convertToDto(csrCustomer);

        DataResult<CsrCustomerDto> result = csrCustomerService.findById(1L);

        assertEquals(dataResultCsrCustomerDto.getData(),result.getData());
    }

    @Test
    void findById_customerCreditNotFound() {
        Exception exception = assertThrows(Exception.class, () -> csrCustomerService.findById(11L));
        assertEquals(CsrCustomerNotFoundException.class, exception.getClass());
    }

    @Test
    void findByIdentityNumber() {
        CsrCustomer csrCustomer = CsrCustomerServiceImplDataProvider.getCsrCustomerByIdentityNumber("12345678912");

        when(csrCustomerEntityService.findById(1L)).thenReturn(csrCustomer);

        DataResult<CsrCustomerDto> dataResultCsrCustomerDto = CsrCustomerServiceImplDataProvider.convertToDto(csrCustomer);

        DataResult<CsrCustomerDto> result = csrCustomerService.findById(1L);

        assertEquals(dataResultCsrCustomerDto.getData(),result.getData());
    }

    @Test
    void save() {

        CsrCustomerSaveRequestDto csrCustomerSaveRequestDto= CsrCustomerServiceImplDataProvider.getCsrCustomerSaveRequest();
        CsrCustomer csrCustomer = CsrCustomerServiceImplDataProvider.convertToSaveRequestDto(csrCustomerSaveRequestDto);

        when(customerCheckService.checkIfRealCustomer(csrCustomer)).thenReturn(true);
        when(csrCustomerEntityService.findByIdentityNumber(csrCustomerSaveRequestDto.getIdentityNumber())).thenReturn(null);

        when(csrCustomerEntityService.save(ArgumentMatchers.any(CsrCustomer.class))).thenReturn(csrCustomer);
        DataResult<CsrCustomerDto> customerDtoDataResult = CsrCustomerServiceImplDataProvider.convertToDto(csrCustomer);

        DataResult<CsrCustomerDto> result = csrCustomerService.save(csrCustomerSaveRequestDto);

        assertEquals(customerDtoDataResult.getData(),result.getData() );

    }
    @Test
    void save_notCheckCustomer() {

        CsrCustomerSaveRequestDto csrCustomerSaveRequestDto= CsrCustomerServiceImplDataProvider.getCsrCustomerSaveRequest();
        CsrCustomer csrCustomer = CsrCustomerServiceImplDataProvider.convertToSaveRequestDto(csrCustomerSaveRequestDto);

        when(customerCheckService.checkIfRealCustomer(csrCustomer)).thenReturn(false);

        Exception exception = assertThrows(Exception.class, () -> csrCustomerService.save(csrCustomerSaveRequestDto));

        assertEquals(CsrCustomerNotCheckRealCustomerException.class, exception.getClass());

    }

    @Test
    void delete() {
        CsrCustomer csrCustomer =CsrCustomerServiceImplDataProvider.getCsrCustomerById(1L);
        when(csrCustomerEntityService.findById(1L)).thenReturn(csrCustomer);

        when(csrCustomerEntityService.save(ArgumentMatchers.any(CsrCustomer.class))).thenReturn(csrCustomer);

        Result result = csrCustomerService.delete(1L);

        assertEquals(new Result(true).isSuccess(),result.isSuccess() );
    }
}