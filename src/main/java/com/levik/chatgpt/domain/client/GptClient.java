package com.levik.chatgpt.domain.client;

import com.levik.chatgpt.domain.client.model.GptRequest;
import com.levik.chatgpt.domain.client.model.GptResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "gpt", url = "https://api.openai.com/v1/")
public interface GptClient {

    @PostMapping(value = "/completions", consumes = "application/json", produces = "application/json")
    @ResponseBody GptResponse completions(@RequestBody GptRequest gptRequest);
}
