package com.neurogine.productmanagementportal.service;

import com.neurogine.productmanagementportal.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product create(Product product);
    List<Product> listAllProducts();
    void delete(Long id);
    Optional<Product> findProductById(Long id);
    Product update(Product product,Long id);
}
