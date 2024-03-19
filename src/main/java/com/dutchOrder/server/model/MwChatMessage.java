package com.dutchOrder.server.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MwChatMessage {
	private String message;

	private LocalDateTime timestamp;
}