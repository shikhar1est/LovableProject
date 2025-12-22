package com.project.lovableproject.demo.entity;

import com.project.lovableproject.demo.enums.MessageRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {
    Long id;
    ChatSession chatSession;
    String content;
    String toolCalls;
    Instant tokensUsed;
    Instant createdAt;
    MessageRole role;
}
