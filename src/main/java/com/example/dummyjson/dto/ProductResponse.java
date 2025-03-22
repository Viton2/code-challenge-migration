package com.example.dummyjson.dto;

import java.util.List;

public class ProductResponse {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public ProductResponse() {
    }

    public ProductResponse(List<Product> products) {
        this.products = products;
    }
}