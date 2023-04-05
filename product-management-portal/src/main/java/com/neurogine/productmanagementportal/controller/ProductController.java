package com.neurogine.productmanagementportal.controller;

import com.neurogine.productmanagementportal.model.Product;
import com.neurogine.productmanagementportal.repository.ProductRepository;
import com.neurogine.productmanagementportal.response.ApiResponse;
import com.neurogine.productmanagementportal.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ApiResponse<Product> createProduct(@RequestBody Product product){
        return new ApiResponse<>(HttpStatus.CREATED.value(),"product created successfully!",productService.create(product));
    }

    @GetMapping
    public ApiResponse<List<Product>> listAllProducts(){
        return new ApiResponse<>(HttpStatus.OK.value(), "product list fetched successfully!",productService.listAllProducts());
    }

    @GetMapping("/{id}")
    public ApiResponse<Product> getProductById(@PathVariable Long id){
        return new ApiResponse<>(HttpStatus.OK.value(), "product fetched successfully!",productService.findProductById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<Product> updateProduct(@RequestBody Product product,@PathVariable Long id){
        return new ApiResponse<>(HttpStatus.OK.value(), "product updated successfully!",productService.update(product,id));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "product deleted successfully!",null);
    }
}
