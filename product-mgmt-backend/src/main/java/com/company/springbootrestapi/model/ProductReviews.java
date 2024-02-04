package com.company.springbootrestapi.model;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.hateoas.ResourceSupport;
import com.company.springbootrestapi.controller.ProductController;
import org.springframework.hateoas.Link;

public class ProductReviews extends ResourceSupport{
    public ProductReviews() {
        super();
    }

    public ProductReviews(Long id, Long productID, String review) {
        super();
        this.ID = id;
        this.productID = productID;
        this.review = review;

        add(linkTo(methodOn(ProductController.class).getProduct(productID)).withRel("product"));
        add(linkTo(methodOn(ProductController.class).getReviewsForProduct(productID)).withSelfRel());
    }

    private Long ID;
    private Long productID;
    private String review;



    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
