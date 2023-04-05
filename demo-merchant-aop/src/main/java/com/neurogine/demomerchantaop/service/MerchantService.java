package com.neurogine.demomerchantaop.service;

import com.neurogine.demomerchantaop.annotation.Log;
import com.neurogine.demomerchantaop.model.Merchant;
import com.neurogine.demomerchantaop.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;

    @Log("Executing Method 1")
    public Merchant createMerchant(String name,String merchantId){
        Merchant merchant = new Merchant();
        merchant.setMerchantId(merchantId);
        merchant.setName(name);
        merchantRepository.save(merchant);

        return merchant;
    }

    @Log("Executing Method 2")
    public void deleteMerchant(String merchantId){
        Merchant merchant = new Merchant();
        merchant.setMerchantId(merchantId);
        merchantRepository.delete(merchant);
    }
}
