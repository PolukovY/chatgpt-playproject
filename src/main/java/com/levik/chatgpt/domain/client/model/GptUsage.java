package com.levik.chatgpt.domain.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GptUsage {
    private int promptTokens;
    private int completionTokens;
    private int totalTokens;
}
