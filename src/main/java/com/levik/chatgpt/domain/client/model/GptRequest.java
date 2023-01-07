package com.levik.chatgpt.domain.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GptRequest {
    public static final String TEXT_DAVINCI_003 = "text-davinci-003";
    public static final int MAX_TOKENS = 500;
    public static final int TEMPERATURE = 0;

    private String model = TEXT_DAVINCI_003;
    private int max_tokens = MAX_TOKENS;
    private int temperature = TEMPERATURE;
    private final String prompt;

    public GptRequest(String prompt) {
        this.prompt = prompt;
    }

    public GptRequest(int max_tokens, String prompt) {
        this.max_tokens = max_tokens;
        this.prompt = prompt;
    }
}
