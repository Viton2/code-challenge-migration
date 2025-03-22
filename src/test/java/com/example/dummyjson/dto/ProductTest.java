package com.example.dummyjson.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Double.parseDouble;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductTest {

    @Test
    public void testGetAndSetter(){
        Long expectId = 1L;
        String expectedTitle = "Dummy product title";
        String expectedDescription = "Dummy product description";
        Double expectedPrice = parseDouble("10.0");

        Product product1 = new Product(1L, "Dummy product title", "Dummy product description", 10.0);

        assertEquals(expectId, product1.getId());
        assertEquals(expectedTitle, product1.getTitle());
        assertEquals(expectedDescription, product1.getDescription());
        assertEquals(expectedPrice, product1.getPrice());
    }
}
