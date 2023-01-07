package com.levik.chatgpt.infra.telegram;

import com.levik.chatgpt.domain.GptManager;
import com.levik.chatgpt.domain.client.model.ClientResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
@AllArgsConstructor
public class TelegramManager {

    private GptManager gptManager;

    public ClientResponse handle(Update update) {
        String userId = getClientIdentity(update);
        String command;

        if (update.hasCallbackQuery()) {
            command = update.getCallbackQuery().getData();
        } else {
            command = update.getMessage().getText();
        }

        String answer = gptManager.handle(command, userId);

        log.info("Request: [{}] answer [{}]", command, answer);
        return new ClientResponse(answer);
    }

    private String getClientIdentity(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getFrom().getUserName();
        }

        return update.getCallbackQuery().getMessage().getChat().getUserName();
    }
}
