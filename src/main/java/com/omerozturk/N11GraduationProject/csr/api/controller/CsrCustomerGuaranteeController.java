package com.omerozturk.N11GraduationProject.csr.api.controller;


import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerGuaranteeSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerGuaranteeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers-guarantees")
@CrossOrigin
@RequiredArgsConstructor
public class CsrCustomerGuaranteeController {

    private final CsrCustomerGuaranteeService csrCustomerGuaranteeService;

    @GetMapping
    public ResponseEntity getAll(){
        var result = csrCustomerGuaranteeService.findAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        var result =  csrCustomerGuaranteeService.findById(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity getByCustomerId(@PathVariable Long customerId){
        var result =  csrCustomerGuaranteeService.findByCustomerId(customerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CsrCustomerGuaranteeSaveRequestDto csrCustomerGuaranteeSaveRequestDto){
        var result = csrCustomerGuaranteeService.save(csrCustomerGuaranteeSaveRequestDto);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        var result = csrCustomerGuaranteeService.delete(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
