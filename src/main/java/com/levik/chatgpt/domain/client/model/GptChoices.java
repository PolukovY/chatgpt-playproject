package com.levik.chatgpt.domain.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GptChoices {
    private String text;
    private int index;
    private String logProbs;
    private String finishReason;
}
