package com.omerozturk.N11GraduationProject.csr.api.controller;



import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditResponseDto;
import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerCreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/customer-credits")
@CrossOrigin
@RequiredArgsConstructor
public class CsrCustomerCreditController {

    private final CsrCustomerCreditService csrCustomerCreditService;

    @GetMapping
    public ResponseEntity getAll(){
        var result = csrCustomerCreditService.findAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        var result =  csrCustomerCreditService.findById(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity getByCustomerId(@PathVariable Long customerId){
        var result =  csrCustomerCreditService.findByCustomerId(customerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @GetMapping("/active-credits-customer/{customerId}")
    public ResponseEntity getActiveCreditsByCustomerId(@PathVariable Long customerId){
        var result =  csrCustomerCreditService.findActiveCreditsByCustomerId(customerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @GetMapping("/credit/{creditId}")
    public ResponseEntity findByCreditId(@PathVariable Long creditId){
        var result =  csrCustomerCreditService.findByCreditId(creditId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }


    @PostMapping
    public ResponseEntity applyForCredit(@RequestBody CsrCustomerCreditSaveRequestDto csrCustomerCreditSaveRequestDto){
        var result = csrCustomerCreditService.applyForCredit(csrCustomerCreditSaveRequestDto);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @PostMapping("/response")
    public ResponseEntity customerResponseCredit(@RequestBody CsrCustomerCreditResponseDto csrCustomerCreditResponseDto){
        var result = csrCustomerCreditService.customerResponseCredit(csrCustomerCreditResponseDto);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @GetMapping("/credit-result/{identityNumber}/{dateOfBirth}")
    public ResponseEntity getCustomerCreditsResults(@PathVariable String identityNumber,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")Date dateOfBirth){
        var result =  csrCustomerCreditService.findCustomerCreditsResults(identityNumber,dateOfBirth);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
    @GetMapping("/credit-result-approved/{identityNumber}/{dateOfBirth}")
    public ResponseEntity getCustomerCreditsResultBySystemApproved(@PathVariable String identityNumber,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")Date dateOfBirth){
        var result =  csrCustomerCreditService.findCustomerCreditsResultBySystemApproved(identityNumber,dateOfBirth);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        var result = csrCustomerCreditService.delete(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
