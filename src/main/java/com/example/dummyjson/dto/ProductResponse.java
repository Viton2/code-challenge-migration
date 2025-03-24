package com.example.dummyjson.dto;

import java.util.List;

/**
 * Representa a resposta contendo uma lista de produtos.
 * Usada para encapsular a resposta ao consumir APIs que retornam produtos.
 */
public class ProductResponse {

    /**
     * Lista de produtos retornados na resposta.
     */
    private List<Product> products;

    /**
     * Construtor padrão para a classe {@link ProductResponse}.
     */
    public ProductResponse() {
    }

    /**
     * Construtor que inicializa a lista de produtos.
     *
     * @param products Uma lista de {@link Product} representando os produtos na resposta.
     */
    public ProductResponse(List<Product> products) {
        this.products = products;
    }

    /**
     * Obtém a lista de produtos.
     *
     * @return Uma lista de {@link Product}.
     */
    public List<Product> getProducts() {
        return products;
    }
}