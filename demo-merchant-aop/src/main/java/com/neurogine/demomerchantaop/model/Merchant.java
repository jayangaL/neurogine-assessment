package com.neurogine.demomerchantaop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Merchant {

    @Id
    @Column(name = "Merchant_Id",nullable = false,length = 50)
    private String merchantId;
    private String name;
}
