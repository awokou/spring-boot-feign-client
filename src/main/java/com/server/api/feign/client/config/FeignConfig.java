package com.server.api.feign.client.config;

import feign.Logger;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    /**
     * Custom Feign encoder to handle query parameters.
     * This encoder is used to encode the request body for Feign clients.
     *
     * @return a new instance of UserQueryParamsEncoder
     */
    @Bean
    public Encoder feignEncoder() {
        return new UserQueryParamsEncoder();
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; // Logs request and response details
    }
}
