package com.example.dummyjson.config;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

/**
 * Classe de configuração responsável por criar e configurar instâncias de {@link WebClient}.
 * Inclui configurações de segurança SSL e ajustes para otimizar o uso de memória.
 */
@Configuration
public class WebClientConfig {

    @Value("${dummy-url}")
    private String BASE_URL;

    /**
     * Cria um bean de {@link WebClient} configurado com o URL base especificado.
     *
     * @return Uma instância configurada de {@link WebClient}.
     * @throws SSLException Caso ocorra um erro ao configurar o SSL.
     */
    @Bean
    public WebClient getWebClient() throws SSLException {
        return getBuild(BASE_URL);
    }

    /**
     * Constrói e configura um {@link WebClient} com um {@link HttpClient} seguro
     * e estratégias de troca otimizadas.
     *
     * @param serviceUrl O URL base para o {@link WebClient}.
     * @return Uma instância configurada de {@link WebClient}.
     * @throws SSLException Caso ocorra um erro ao configurar o contexto SSL.
     */
    @NotNull
    private WebClient getBuild(String serviceUrl) throws SSLException {
        SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();

        HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(sslContext));

        final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();

        return WebClient
                .builder()
                .exchangeStrategies(strategies)
                .baseUrl(serviceUrl)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}