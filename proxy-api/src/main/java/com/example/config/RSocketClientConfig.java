package com.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;

@Configuration
public class RSocketClientConfig {

    @Bean
    public RSocketRequester.Builder rSocketRequesterBuilder() {
        return RSocketRequester.builder();
    }

    @Bean
    public RSocketStrategies rSocketStrategies() {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();

        return RSocketStrategies.builder()
                .encoder(new Jackson2JsonEncoder(objectMapper))
                .decoder(new Jackson2JsonDecoder(objectMapper))
                .build();
    }

    @Bean
    @Qualifier("eventServiceRequester")
    public RSocketRequester rSocketRequesterEvent(RSocketRequester.Builder builder, RSocketStrategies rSocketStrategies) {
        return builder
                .rsocketStrategies(rSocketStrategies)
                .connectTcp("localhost", 7000)
                .block();
    }

    @Bean
    @Qualifier("userServiceRequester")
    public RSocketRequester rSocketRequesterUser(RSocketRequester.Builder builder, RSocketStrategies rSocketStrategies) {
        return builder
                .rsocketStrategies(rSocketStrategies)
                .connectTcp("localhost", 7001)
                .block();
    }

}
