package com.example.dummyjson.controller;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Classe de teste para o controlador {@link ProductController}.
 * Verifica as funcionalidades relacionadas aos endpoints de produtos utilizando mocks.
 */
@SpringBootTest
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    /**
     * Testa o método {@link ProductController#getAllProducts()}.
     * Verifica se o controlador retorna a lista de produtos corretamente.
     */
    @Test
    public void testGetAllProducts() {
        Product product1 = new Product(1L, "Product 1", "Produto 1", 10.0);
        Product product2 = new Product(2L, "Product 2", "Produto 2", 20.0);
        List<Product> products = Arrays.asList(product1, product2);

        when(productService.getAllProducts()).thenReturn(products);

        List<Product> result = productController.getAllProducts();

        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getTitle());
    }

    /**
     * Testa o método {@link ProductController#getProductById(Long)}.
     * Verifica se o controlador retorna o produto correto com base no ID fornecido.
     */
    @Test
    public void testGetProductById() {
        Product product = new Product(1L, "Product 1", "Produto 1", 10.0);
        when(productService.getProductById(1L)).thenReturn(product);
        Product result = productController.getProductById(1L);
        assertEquals("Product 1", result.getTitle());
    }
}
