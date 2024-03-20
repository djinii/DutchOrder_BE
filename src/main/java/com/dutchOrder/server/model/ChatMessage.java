package com.dutchOrder.server.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ChatMessage {
	private String message;

	private LocalDateTime timestamp;
}
