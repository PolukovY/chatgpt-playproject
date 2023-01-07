package com.levik.chatgpt.domain.client.service;

import com.levik.chatgpt.domain.client.GptClient;
import com.levik.chatgpt.domain.client.model.GptRequest;
import com.levik.chatgpt.domain.client.model.GptResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class GptService {

    private final GptClient gptClient;

    public GptResponse completions(GptRequest gptRequest) {
        return gptClient.completions(gptRequest);
    }
}
