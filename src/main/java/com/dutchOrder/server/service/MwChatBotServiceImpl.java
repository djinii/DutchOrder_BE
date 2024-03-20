package com.dutchOrder.server.service;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.MwChatBotDao;
import com.dutchOrder.server.model.Menu;
import com.dutchOrder.server.model.OrderSpec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MwChatBotServiceImpl implements MwChatBotService {

	private final MwChatBotDao md;



	@Override
	public String recommendMenuByTime(LocalDateTime timestamp) {
		System.out.println("MwServiceImpl recommendMenuByTime Start...");
		// 타임스탬프에서 시간만 추출
		LocalTime time = timestamp.toLocalTime();
		System.out.println("recommendMenuByTime time: "+time);
        String menu;

        // 시간대에 따라 다른 추천 메뉴를 선택합니다.
        if (time.isBefore(LocalTime.of(8, 0))) {
            // 아침 시간대: 아침 메뉴 추천
            menu = md.manyBreakfastOrder();
        } else if (time.isBefore(LocalTime.of(15, 0))) {
            // 점심 시간대: 점심 메뉴 추천
            menu = md.manyLunchOrder();
        } else {
            // 저녁 시간대: 저녁 메뉴 추천
            menu = md.manyDinnerOrder();
        }

        return menu;
	}

	
	
}