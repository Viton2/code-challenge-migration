package com.example.dummyjson.dto;

public class ProductResponse {

    private Product[] products;

    public Product[] getProducts() {
        return products;
    }

    public ProductResponse() {
    }

    public ProductResponse(Product[] products) {
        this.products = products;
    }
}