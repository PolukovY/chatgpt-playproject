package com.levik.chatgpt.domain;

import com.levik.chatgpt.domain.client.model.GptChoices;
import com.levik.chatgpt.domain.client.model.GptRequest;
import com.levik.chatgpt.domain.client.service.GptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
public class GptManager {

    public static final String NEXT_LINE = "\n";
    private static final String WELCOME_MESSAGE = "Welcome to Chat Gpt telegram test bot.";
    private final GptService gptService;
    public String handle(String message, String userIdentity) {

        if (message.startsWith("/")) {
            return WELCOME_MESSAGE;
        }

        var gptRequest = new GptRequest(message);
        var gptResponse = gptService.completions(gptRequest);

        return gptResponse
                .getChoices()
                .stream()
                .map(GptChoices::getText)
                .collect(Collectors.joining(NEXT_LINE));
    }
}
