package com.levik.chatgpt.infra.telegram.service;

import com.levik.chatgpt.domain.client.model.ClientResponse;
import com.levik.chatgpt.infra.telegram.Bot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Slf4j
@Service
public class TelegramSendMessageApi implements SendMessageApi {

    @Override
    public void send(Bot bot, ClientResponse clientResponse, Long sendTo) {
        log.info("Send message to chatId {} preparing...", sendTo);
        var sendMessage = createSendMessage(clientResponse.body(), sendTo);
        try {
            bot.execute(sendMessage);
            log.info("Send message to chatId {} completed with wait 1 sec", sendTo);
            //Added sleep to not reach limit
            TimeUnit.SECONDS.sleep(1);
        } catch (TelegramApiRequestException exe) {
            log.info("Can't send message {}, looks like user stop using bot, chatId {}",
                    exe.getMessage(), sendTo);
        } catch (Exception exe) {
            log.error("Can't send message to {}", sendTo, exe);
        }
    }

    private SendMessage createSendMessage(String text, Long sendTo) {
        return SendMessage.builder()
                .chatId(String.valueOf(sendTo))
                .text(text)
                .parseMode(ParseMode.HTML)
                .build();
    }
}
