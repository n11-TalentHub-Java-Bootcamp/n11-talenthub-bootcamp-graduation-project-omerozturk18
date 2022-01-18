package com.omerozturk.N11GraduationProject.csr.api.controller;


import com.omerozturk.N11GraduationProject.csr.entities.dtos.CsrCustomerSaveRequestDto;
import com.omerozturk.N11GraduationProject.csr.services.abstracts.CsrCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
@RequiredArgsConstructor
public class CsrCustomerController {

    private final CsrCustomerService csrCustomerService;

    @GetMapping
    public ResponseEntity getAll(){
        var result = csrCustomerService.findAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        var result =  csrCustomerService.findById(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/identityNumber/{identityNumber}")
    public ResponseEntity getByIdentityNumber(@PathVariable String identityNumber){
        var result =  csrCustomerService.findByIdentityNumber(identityNumber);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CsrCustomerSaveRequestDto csrCustomerSaveRequestDto){
        var result = csrCustomerService.save(csrCustomerSaveRequestDto);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        var result = csrCustomerService.delete(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
