package com.example.dummyjson.actuator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ActuatorHealthCheckTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void shouldReturn200WhenSendingRequestToManagementEndpoint(){
        int port = 9001;
        webClient.get().uri("http://localhost:"+ port +"/health").exchange().expectStatus().isOk();
    }

}
