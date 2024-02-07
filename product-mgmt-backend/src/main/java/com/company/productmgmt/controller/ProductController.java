package com.company.productmgmt.controller;

import com.company.productmgmt.model.Product;
import com.company.productmgmt.service.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.Duration;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    Flux<Product> getProducts() {

        return productService.getProducts();
    }

    @PostMapping("/products")
    Mono<Product> postProducts(@Valid @RequestBody Product product) {

        return productService.createProduct(product);
    }

    @GetMapping("/products/{id}")
    public Mono<Product> getProductById(@PathVariable(value = "id") Long productId) {
        return productService.getProduct(productId);
    }

    @PutMapping("/products/{id}")
    public Mono<Product> updateProduct(@PathVariable(value = "id") Long productId, @Valid @RequestBody Product product) {
        product.setId(productId);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public Mono<Void> deleteProduct(@PathVariable(value = "id") Long productId) {

        return productService.deleteProduct(productId);
    }

    // Products are Sent to the client as Server Sent Events
    @GetMapping(value = "/stream/products", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> streamAllProducts() {
        return productService.getProducts().delayElements(Duration.ofSeconds(1));
    }

}
