package com.company.productmgmt.service;

import com.company.productmgmt.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> getProducts();
    Mono<Product> getProduct(Long id);
    Mono<Product> createProduct(Product product);
    Mono<Product> updateProduct(Product product);
    Mono<Void> deleteProduct(Long id);
}
