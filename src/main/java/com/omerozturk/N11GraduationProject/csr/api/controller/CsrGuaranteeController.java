package com.omerozturk.N11GraduationProject.csr.api.controller;


import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrGuaranteeSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrGuaranteeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guarantees")
@CrossOrigin
@RequiredArgsConstructor
public class CsrGuaranteeController {

    private final CsrGuaranteeService csrGuaranteeService;

    @GetMapping
    public ResponseEntity getAll(){
        var result = csrGuaranteeService.findAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        var result =  csrGuaranteeService.findById(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity getByCustomerId(@PathVariable Long customerId){
        var result =  csrGuaranteeService.findByCustomerId(customerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CsrGuaranteeSaveRequestDto csrGuaranteeSaveRequestDto){
        var result = csrGuaranteeService.save(csrGuaranteeSaveRequestDto);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/all")
    public ResponseEntity saveAll(@RequestBody List<CsrGuaranteeSaveRequestDto> csrGuaranteeSaveRequestDtoList){
        var result = csrGuaranteeService.saveAll(csrGuaranteeSaveRequestDtoList);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        var result = csrGuaranteeService.delete(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
