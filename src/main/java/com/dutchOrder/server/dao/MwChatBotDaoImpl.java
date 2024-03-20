package com.dutchOrder.server.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.Menu;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MwChatBotDaoImpl implements MwChatBotDao {
	// MyBatis DB 연동
	private final SqlSession session;


	@Override
	public String manyDinnerOrder() {
		Menu mwMenu = null;
		System.out.println("MwDaoImpl manyDinnerMenu Start...");
		try {
			mwMenu = session.selectOne("manyDinnerMenu");
		} catch(Exception e) {
			System.out.println("MwDaoImpl manyDinnerMenu e.getMessage()->"+e.getMessage());
		}
		return mwMenu.getFname();
	}

	@Override
	public String manyLunchOrder() {
		Menu mwMenu = null;
		System.out.println("MwDaoImpl manyLunchMenu Start...");
		try {
			mwMenu = session.selectOne("manyLunchMenu");
		} catch(Exception e) {
			System.out.println("MwDaoImpl manyLunchMenu e.getMessage()->"+e.getMessage());
		}
		return mwMenu.getFname();
	}

	@Override
	public String manyBreakfastOrder() {
		Menu mwMenu = null;
		System.out.println("MwDaoImpl manyBreakfastMenu Start...");
		try {
			mwMenu = session.selectOne("manyBreakfastMenu");
		} catch(Exception e) {
			System.out.println("MwDaoImpl manyBreakfastMenu e.getMessage()->"+e.getMessage());
		}
		return mwMenu.getFname();
	}
	
}