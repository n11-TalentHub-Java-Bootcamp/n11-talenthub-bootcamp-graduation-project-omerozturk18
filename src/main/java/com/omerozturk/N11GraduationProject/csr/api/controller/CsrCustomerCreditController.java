package com.omerozturk.N11GraduationProject.csr.api.controller;


import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerCreditSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerCreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/credit/{creditId}")
    public ResponseEntity findByCreditId(@PathVariable Long creditId){
        var result =  csrCustomerCreditService.findByCreditId(creditId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }


    @PostMapping
    public ResponseEntity create(@RequestBody CsrCustomerCreditSaveRequestDto csrCustomerCreditSaveRequestDto){
        var result = csrCustomerCreditService.save(csrCustomerCreditSaveRequestDto);
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
