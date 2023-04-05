package com.neurogine.demomerchantaop.repository;

import com.neurogine.demomerchantaop.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant,String> {
}
