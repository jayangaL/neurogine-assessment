package com.neurogine.productmanagementportal.repository;

import com.neurogine.productmanagementportal.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
