package com.example.dummyjson.actuator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.hamcrest.Matchers.equalTo;

/**
 * Classe de teste que verifica a saúde do endpoint Actuator.
 * Utiliza {@link WebTestClient} para testar endpoints de forma reativa.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class ActuatorHealthCheckTest {

        @Autowired
        private WebTestClient webTestClient;

        /**
         * Testa o endpoint "/health" do Actuator.
         * Verifica se o endpoint retorna o status HTTP 200 (OK) e se o status do sistema é "UP".
         */
        @Test
        public void testHealthEndpoint() {
                webTestClient.get().uri("/health")
                        .exchange()
                        .expectStatus().isOk()
                        .expectBody()
                        .jsonPath("$.status").value(equalTo("UP")); // Verifica se o status está "UP"
        }
}
