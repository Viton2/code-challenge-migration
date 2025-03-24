package com.example.dummyjson.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Representa um produto com propriedades como ID, título, descrição e preço.
 * Utiliza validações para garantir a consistência dos dados.
 */
public class Product {

    /**
     * ID do produto.
     * Deve ser um valor não nulo entre 0 e 999.
     */
    @NotNull
    @Min(0L)
    @Max(999L)
    private Long id;

    /**
     * Título do produto.
     * Não pode ser nulo.
     */
    @NotNull
    private String title;

    /**
     * Descrição do produto.
     * Não pode ser nulo.
     */
    @NotNull
    private String description;

    /**
     * Preço do produto.
     * Não pode ser nulo.
     */
    @NotNull
    private Double price;

    /**
     * Construtor que inicializa todas as propriedades do produto.
     *
     * @param id          ID do produto. Deve ser entre 0 e 999.
     * @param title       Título do produto.
     * @param description Descrição do produto.
     * @param price       Preço do produto.
     */
    public Product(Long id, String title, String description, Double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    /**
     * Obtém o ID do produto.
     *
     * @return O ID do produto.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do produto.
     *
     * @param id O novo ID do produto. Deve ser entre 0 e 999.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o título do produto.
     *
     * @return O título do produto.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define o título do produto.
     *
     * @param title O novo título do produto.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Obtém a descrição do produto.
     *
     * @return A descrição do produto.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define a descrição do produto.
     *
     * @param description A nova descrição do produto.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtém o preço do produto.
     *
     * @return O preço do produto.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Define o preço do produto.
     *
     * @param price O novo preço do produto.
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}
