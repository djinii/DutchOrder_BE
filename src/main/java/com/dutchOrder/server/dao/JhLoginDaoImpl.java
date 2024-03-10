package com.dutchOrder.server.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.JhMember;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JhLoginDaoImpl implements JhLoginDao {
	
	private final SqlSession sqlSession;
	
	@Override
    public boolean login(String memail, String mpw) {
		// 사용자 인증을 위한 파라미터 맵 생성
		Map<String, Object> params = new HashMap<>();
		params.put("memail", memail);
		params.put("mpw", mpw);
		
		// SQL 쿼리 실행
		boolean result = sqlSession.selectOne("login", params);
		System.out.println(result);
		return result;
	}

	@Override
	public int getUserLevel(String memail) {
		Map<String, Object> params = new HashMap<>();
		params.put("memail", memail);
		
		int result = sqlSession.selectOne("getUserLevel", params);
 		return result;
	}



}
