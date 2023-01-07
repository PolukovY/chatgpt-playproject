package com.levik.chatgpt.infra.telegram.service;

import com.levik.chatgpt.domain.client.model.ClientResponse;
import com.levik.chatgpt.infra.telegram.Bot;

public interface SendMessageApi {

    void send(Bot bot, ClientResponse clientResponse, Long sendTo);
}
