package com.neurogine.demomerchantaop.controller;


import com.neurogine.demomerchantaop.annotation.Log;
import com.neurogine.demomerchantaop.model.Merchant;
import com.neurogine.demomerchantaop.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/merchants")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @PostMapping
    public ResponseEntity<Merchant> createMerchant(@RequestBody Merchant merchant){
        Merchant merchant1 = merchantService.createMerchant(merchant.getName(),merchant.getMerchantId());
        return new ResponseEntity<>(merchant1, HttpStatus.CREATED);
    }
}
