package com.levik.chatgpt.infra.telegram;

import com.levik.chatgpt.domain.client.model.ClientResponse;
import com.levik.chatgpt.infra.telegram.properties.BotProperties;
import com.levik.chatgpt.infra.telegram.service.SendMessageApi;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class Bot extends TelegramLongPollingBot {

    private final BotProperties botProperties;
    private final TelegramManager telegramManager;
    private final SendMessageApi sendMessageApi;

    @PostConstruct
    public void onInit() {
        log.info("TelegramBotsApi username {} configured...", getBotUsername());
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info("Received message {}", update);
        ClientResponse action = telegramManager.handle(update);
        var message = update.getMessage();
        Long sendTo = Objects.nonNull(message) ? message.getChatId() : update.getCallbackQuery().getMessage().getChatId();
        sendMessageApi.send(this, action, sendTo);
    }

    @Override
    public String getBotUsername() {
        return botProperties.getUsername();
    }

    @Override
    public String getBotToken() {
        return botProperties.getToken();
    }
}
