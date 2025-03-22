package com.example.dummyjson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebTestClientConfig {

    @Bean
    public WebTestClient webTestClient(WebClient.Builder webClientBuilder) {
        return WebTestClient.bindToServer()
                .baseUrl("https://dummyjson.com") // Ajuste a URL para o ambiente de teste
                .build();
    }
}