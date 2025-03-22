package com.example.dummyjson.config;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.reactive.function.client.WebClient;

import javax.net.ssl.SSLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class WebClientConfigTest {

    @Autowired
    WebClient webClient;

    @Test
    public void testWebClientConfig(){
        assertNotNull(webClient);  // Verifica se o WebClient não é nulo
    }
}
