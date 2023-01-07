package com.levik.chatgpt.domain.client.security;

import com.levik.chatgpt.domain.client.properties.GptProperties;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GptSecurityConfiguration {


    @Bean
    public RequestInterceptor requestInterceptor(GptProperties gptProperties) {
        return new TokenRequestInterceptor(gptProperties.getToken());
    }
}
