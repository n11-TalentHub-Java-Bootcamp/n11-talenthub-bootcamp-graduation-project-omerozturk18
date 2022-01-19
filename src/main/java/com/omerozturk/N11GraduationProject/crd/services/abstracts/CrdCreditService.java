package com.omerozturk.N11GraduationProject.crd.services.abstracts;

import com.omerozturk.N11GraduationProject.crd.entities.dtos.CrdCreditDto;
import com.omerozturk.N11GraduationProject.crd.entities.dtos.CrdCreditSaveRequestDto;
import com.omerozturk.N11GraduationProject.gen.utilities.result.DataResult;
import com.omerozturk.N11GraduationProject.gen.utilities.result.Result;

import java.util.List;

public interface CrdCreditService {
    DataResult<List<CrdCreditDto>> findAll();
    DataResult<CrdCreditDto> findById(Long id);
    DataResult<CrdCreditDto> findByName(String creditName);
    DataResult<CrdCreditDto> save(CrdCreditSaveRequestDto crdCreditSaveRequestDto);
    Result delete(Long id);
}
