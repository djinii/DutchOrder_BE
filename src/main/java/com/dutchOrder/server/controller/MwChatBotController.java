package com.dutchOrder.server.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.dutchOrder.server.model.ChatMessage;
import com.dutchOrder.server.service.MwChatBotService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MwChatBotController {
	
	private final MwChatBotService ms;
	
	@Value("${chatgpt.api.key}")
    private String apiKey;

    @Value("${chatgpt.api.endpoint}")
    private String apiEndpoint;

    @ResponseBody
    @PostMapping("/api/chat")		
    // ResponseEntity<String>: http 응답에 포함될 문자열 데이터를 나타내는 객체
    public ResponseEntity<String> handleChatMessage(@RequestBody ChatMessage message) {
        // 받은 메시지를 기반으로 챗봇 로직을 수행하고, 적절한 응답을 생성하여 반환
        String response;
        
        if (message.getMessage().contains("추천")) {
        	// 입력메세지에 추천이 포함되어있으면 메뉴추천 로직 수행
            response = generateResponse(message);
        } else {
        	// 추천이 포함되어 있지 않으면 api응답 수행
        	System.out.println("handleChatMessage message-->"+message.getMessage());
            response = chatWithGPT(message.getMessage());
        }
        // 클라이언트에게 응답이 성공적으로 전될되었음을 알려주면서 데이터 반환
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 챗봇 로직을 수행하여 응답을 생성하는 메소드
    private String generateResponse(ChatMessage message1) {
        System.out.println("MwController generateResponse Start...");
        String userMsg = message1.getMessage();
        System.out.println("사용자 메세지: " + userMsg);
        message1.setTimestamp(LocalDateTime.now());

        // 챗봇 응답 생성
        LocalDateTime timestamp = message1.getTimestamp();
        String recommendedMenu = ms.recommendMenuByTime(timestamp);
        System.out.println("MwController generateResponse manyOrderMenu: " + recommendedMenu);
        return "추천메뉴는 " + recommendedMenu + " 입니다";
    }

    // ChatGPT API 호출 메소드
    private String chatWithGPT(String userMessage) {
        // ChatGPT API 호출
    	// HTTP 통신을 위한 클라이언트 생성
        RestTemplate restTemplate = new RestTemplate();
        // JSON형식의 데이터를 문자열로 생성하여 api에 보냄
        String requestBody = "{\"model\":\"gpt-3.5-turbo\",\"messages\":[{\"role\":\"user\",\"content\":\"" +
                              userMessage + "\"}],\"temperature\":0.8,\"max_tokens\":150,\"stop\":[\"\\n\",\"User:\",\"Bot:\"],\"n\":1}";
        // HTTP 요청의 헤더를 생성
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);
        // HTTP 본문과 헤더를 함께 담을 객체
        // JSON 형식의 데이터를 포함하는 HTTP 요청을 생성
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(apiEndpoint, entity, String.class);
        System.out.println("response-->"+response);
        
//        // JSON 데이터를 파싱하여 content 필드 추출
//        JsonParser jsonParser = JsonParserFactory.getJsonParser();
//        Map<String, Object> jsonResponse = jsonParser.parseMap(response);
//
//        // choices 배열에서 첫 번째 요소의 message 객체를 찾아서 content 필드 추출
//        List<Map<String, Object>> choices = (List<Map<String, Object>>) jsonResponse.get("choices");
//        String content = (String) ((Map<String, Object>) choices.get(0).get("message")).get("content");
//
//        System.out.println("챗봇응답: " + content);

        // Jackson ObjectMapper를 사용하여 JSON 문자열을 처리
        ObjectMapper objectMapper = new ObjectMapper();
        try {
        	// HTTP응답을 JSON 트리로 읽음(JSON 데이터를 자바 객체로 변환할 수 있음)
            JsonNode jsonResponse = objectMapper.readTree(response.getBody());
            // choices 라는 키에 해당하는 배열을 가져옴
            JsonNode choices = jsonResponse.get("choices");
            // choices 배열의 첫번째 요소를 가져옴
            JsonNode firstChoice = choices.get(0);
            // 첫번째 요소에서 message 키에 해당하는 값을 가져옴
            JsonNode message = firstChoice.get("message");
            // message 객체에서 content키의 값을 가져와 asText()메소드로 문자열로 변환
            String content = message.get("content").asText();
            return content;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing JSON";
        }
    }
	
}