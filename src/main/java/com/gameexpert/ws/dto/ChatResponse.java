package com.gameexpert.ws.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Getter
public class ChatResponse {
    private final String type = "chat";
    private final String sender;
    private final String content;
    private final LocalDateTime timestamp;

    // TODO Lv 13: API 명세에 맞게 응답 필드와 생성자를 완성합니다.
    public ChatResponse(String sender, String content, LocalDateTime timestamp) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }
}
