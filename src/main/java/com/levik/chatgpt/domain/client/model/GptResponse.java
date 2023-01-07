package com.levik.chatgpt.domain.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class GptResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    private List<GptChoices> choices;
    private GptUsage usage;
}
