package com.company.springbootrestapi.repository;

import com.company.springbootrestapi.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}
