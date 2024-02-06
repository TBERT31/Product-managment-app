package com.company.productmgmt.service;

import com.company.productmgmt.model.Product;
import com.company.productmgmt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    NextSequenceService nextSequenceService;

    @Override
    public Flux<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> createProduct(Product product) {
        product.setId(nextSequenceService.getNextSequence("customSequences"));
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> updateProduct(Product product) {
        return productRepository.findById(product.getId()).flatMap(existingProduct -> {
            existingProduct.setProductName(product.getProductName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setProductDesc(product.getProductDesc());
            return productRepository.save(existingProduct);
        });
    }

    @Override
    public Mono<Void> deleteProduct(Long id) {
        return productRepository.deleteById(id);
    }
}
