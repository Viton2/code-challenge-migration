package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Classe de teste para o serviço {@link ProductService}.
 * Verifica as funcionalidades relacionadas a produtos utilizando mocks.
 */
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceTest {

    @MockBean
    private ProductService productService;

    /**
     * Testa o método {@link ProductService#getAllProducts()}.
     * Verifica se o serviço retorna a lista de produtos corretamente.
     */
    @Test
    void testGetAllProducts() {
        Product product1 = new Product(1L, "Product 1", "Produto 1", 10.0);
        Product product2 = new Product(2L, "Product 2", "Produto 2", 20.0);

        ProductResponse response = new ProductResponse(List.of(product1, product2));
        when(productService.getAllProducts())
                .thenReturn(response.getProducts());

        assertEquals(response.getProducts(), productService.getAllProducts());

        verify(productService).getAllProducts();
    }

    /**
     * Testa o método {@link ProductService#getProductById(Long)}.
     * Verifica se o serviço retorna o produto correto com base no ID.
     */
    @Test
    public void testGetProductById() {
        Product product = new Product(1L, "Product 1", "Produto 1", 10.0);

        when(productService.getProductById(1L)).thenReturn(product);

        assertEquals(product, productService.getProductById(1L));
    }
}
