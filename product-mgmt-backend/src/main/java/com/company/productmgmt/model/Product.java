package com.company.productmgmt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Product")
public class Product {


    public Product() {
        super();
    }


    public Product(Long id, String productName, Integer price, String productDesc) {
        super();
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.productDesc = productDesc;
    }

    @Id
    private Long id;
    private String productName;
    private Integer price;
    private String productDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
