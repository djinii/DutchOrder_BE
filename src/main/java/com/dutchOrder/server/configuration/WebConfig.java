package com.dutchOrder.server.configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


@Configuration
public class WebConfig implements WebMvcConfigurer {
	// vue.js랑 연결관련 클래스
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 허용할 URL 패턴
                .allowedOrigins("http://localhost:8080","http://localhost:8081") // 클라이언트(Vue) 포트
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드
                .allowCredentials(true); // 인증 정보 허용
    }
}
