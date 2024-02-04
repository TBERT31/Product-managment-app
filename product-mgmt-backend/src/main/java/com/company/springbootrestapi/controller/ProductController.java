package com.company.springbootrestapi.controller;



import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.company.springbootrestapi.model.Product;
import com.company.springbootrestapi.model.ProductReviews;
import com.company.springbootrestapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "getproducts")
    public ResponseEntity<List<Product>> handle2(){
        CacheControl cacheControl = CacheControl.noCache();
        return ResponseEntity.ok().cacheControl(cacheControl).body(productService.getProducts());
    }

    @GetMapping("")
    List<Product> getProducts(){
        return productService.getProducts();
    };

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);
    };

    @PostMapping(value = "")
    public Map<String, Object> createProduct(@RequestParam(value = "id") Long id,
                                             @RequestParam(value = "name") String name,
                                             @RequestParam(value = "price") Integer price
    ) {
        productService.createProduct(id, name, price);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "Product added!");
        return map;
    }

    @PutMapping(value = "")
    public Product updateProductUsingJson(@RequestBody Product product){
        productService.updateProduct(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "Product deleted!");
        return map;
    }

    @GetMapping(value = "/{productId}/reviews")
    public Resources<ProductReviews> getReviewsForProduct(@PathVariable final long productId) {

        List<ProductReviews> reviews = productService.getProductReviews(productId);
        return new Resources<ProductReviews>(reviews);

    }
}
