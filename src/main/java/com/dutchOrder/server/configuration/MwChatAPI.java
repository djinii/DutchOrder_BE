package com.dutchOrder.server.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@ConfigurationProperties("chatgpt.api")
public class MwChatAPI {
	private String key;
	private String endpoint;
}