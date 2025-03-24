package com.example.dummyjson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação que inicia o cliente DummyJson.
 */

@SpringBootApplication
public class DummyJsonClientApplication {

    /**
     * Método principal que inicia a aplicação.
     *
     * @param args Argumentos de linha de comando.
     */


    public static void main(String[] args) {
        SpringApplication.run(DummyJsonClientApplication.class, args);
    }
}
