package com.omerozturk.N11GraduationProject.cnt.api.controller;



import com.omerozturk.N11GraduationProject.cnt.entities.dtos.CntMessageSaveRequestDto;
import com.omerozturk.N11GraduationProject.cnt.services.abstracts.CntMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
@CrossOrigin
@RequiredArgsConstructor
public class CntMessageController {

    private final CntMessageService cntMessageService;

    @GetMapping
    public ResponseEntity getAll(){
        var result = cntMessageService.findAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        var result =  cntMessageService.findById(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/phone/{phoneNuber}")
    public ResponseEntity getByPhoneNumber(@PathVariable String phoneNumber){
        var result =  cntMessageService.findByPhoneNumber(phoneNumber);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CntMessageSaveRequestDto cntMessageSaveRequestDto){
        var result = cntMessageService.save(cntMessageSaveRequestDto);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        var result = cntMessageService.delete(id);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
