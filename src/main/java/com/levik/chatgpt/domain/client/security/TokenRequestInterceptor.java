package com.levik.chatgpt.domain.client.security;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TokenRequestInterceptor implements RequestInterceptor {

    private final String token;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", "Bearer " + token);
    }

}
