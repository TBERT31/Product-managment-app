package com.company.springbootrestapi.service;

import com.company.springbootrestapi.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProduct(Long id);
    void createProduct(Long productID, String productName, Integer price);
    void updateProduct(Product product);
    void deleteProduct(Long id);

    List<ProductReviews> getProductReviews(Long id);
}
