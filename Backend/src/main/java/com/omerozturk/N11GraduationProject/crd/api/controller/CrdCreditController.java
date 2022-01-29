package com.omerozturk.N11GraduationProject.crd.api.controller;


import com.omerozturk.N11GraduationProject.crd.entities.dtos.CrdCreditSaveRequestDto;
import com.omerozturk.N11GraduationProject.crd.services.abstracts.CrdCreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/credits")
@CrossOrigin
@RequiredArgsConstructor
public class CrdCreditController {

    private final CrdCreditService crdCreditCreditService;

    @GetMapping
    public ResponseEntity getAll(){
        var result = crdCreditCreditService.findAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        var result =  crdCreditCreditService.findById(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/name/{creditName}")
    public ResponseEntity getByCreditName(@PathVariable String creditName){
        var result =  crdCreditCreditService.findByCreditName(creditName);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody CrdCreditSaveRequestDto crdCreditCreditSaveRequestDto){
        var result = crdCreditCreditService.save(crdCreditCreditSaveRequestDto);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        var result = crdCreditCreditService.delete(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
