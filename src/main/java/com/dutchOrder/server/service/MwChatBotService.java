package com.dutchOrder.server.service;

import java.time.LocalDateTime;

import com.dutchOrder.server.model.Menu;

public interface MwChatBotService {

	
	String recommendMenuByTime(LocalDateTime timestamp);
}