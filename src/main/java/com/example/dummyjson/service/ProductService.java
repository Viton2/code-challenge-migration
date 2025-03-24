package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

/**
 * Serviço responsável por consumir APIs relacionadas a produtos usando WebClient.
 */
@Service
public class ProductService {

    private final WebClient webClient;

    /**
     * Construtor que inicializa o WebClient.
     *
     * @param webClient Instância de {@link WebClient} usada para realizar chamadas HTTP.
     */
    public ProductService(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Obtém a lista de todos os produtos.
     *
     * @return Uma lista de {@link Product}. Retorna uma lista vazia se a resposta for nula.
     */
    public List<Product> getAllProducts() {
        ProductResponse response = webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToMono(ProductResponse.class)
                .block();
        return response != null ? response.getProducts() : Collections.emptyList();
    }

    /**
     * Obtém os detalhes de um produto específico com base no ID fornecido.
     *
     * @param id O ID do produto a ser buscado.
     * @return Uma instância de {@link Product} correspondente ao ID fornecido.
     */
    public Product getProductById(Long id) {
        return webClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }
}

