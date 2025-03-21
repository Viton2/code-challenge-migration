package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    private final String BASE_URL = "https://dummyjson.com/products";

    @Autowired
    private RestTemplate restTemplate;

    public List<Product> getAllProducts() {

        System.out.println("Java version: " + System.getProperty("java.version"));
        ProductResponse response = restTemplate.getForObject(BASE_URL, ProductResponse.class);
        return response != null ? Arrays.asList(response.getProducts()) : Collections.emptyList();
    }

    public Product getProductById(Long id) {
        String url = BASE_URL + "/" + id;
        return restTemplate.getForObject(url, Product.class);
    }
}
