package com.neurogine.productmanagementportal.service.Impl;

import com.neurogine.productmanagementportal.model.Product;
import com.neurogine.productmanagementportal.repository.ProductRepository;
import com.neurogine.productmanagementportal.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product update(Product product, Long id) {
        Optional<Product> productPersist = productRepository.findById(id);
        Product product1 = new Product();

        if(productPersist.isPresent()){
            product1.setId(id);
            if(product.getName()!=null) {
                product1.setName(product.getName());
            }
            if(product.getDescription()!=null){
                product1.setDescription(product.getDescription());
            }
            if(product.getPrice()!=null) {
                product1.setPrice(product.getPrice());
            }
            if(product.getCategory()!=null){
                product1.setCategory(product.getCategory());
            }
        }
        return productRepository.save(product1);
    }
}
