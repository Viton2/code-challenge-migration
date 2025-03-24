package com.example.dummyjson.config;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Classe de teste para a configuração do {@link WebClient}.
 * Verifica se o bean {@link WebClient} foi corretamente inicializado no contexto do Spring.
 */
@SpringBootTest
public class WebClientConfigTest {

    @Autowired
    WebClient webClient;

    /**
     * Testa a configuração do {@link WebClient}.
     * Assegura que o bean {@link WebClient} não é nulo após a inicialização.
     */
    @Test
    public void testWebClientConfig() {
        assertNotNull(webClient); // Verifica se o WebClient não é nulo
    }
}
