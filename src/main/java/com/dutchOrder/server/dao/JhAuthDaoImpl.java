package com.dutchOrder.server.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.dutchOrder.server.dto.JhMemberDto;
import com.dutchOrder.server.model.JhMember;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
public class JhAuthDaoImpl implements JhAuthDao {
	
	private final SqlSession sqlSession;
	
	public JhAuthDaoImpl(SqlSession sqlSession) {
	    this.sqlSession = sqlSession;
	}
	
	@Override
    public boolean login(String memail, String mpw) {
		// 사용자 인증을 위한 파라미터 맵 생성
		Map<String, Object> params = new HashMap<>();
		params.put("memail", memail);
		params.put("mpw", mpw);
		
		// SQL 쿼리 실행
		Boolean result = sqlSession.selectOne("login", params);
		System.out.println(result);
		
		if (result == null) {
			return false;		
		}
		 
		return result.booleanValue(); 
	} 

	@Override
	public int getUserLevel(String memail) {
		Map<String, Object> params = new HashMap<>();
		params.put("memail", memail);
		
		int result = sqlSession.selectOne("getUserLevel", params);
 		return result;
	}
	
	@Override
	public String findMyEmail(String mname, String mtel) {
		Map<String, Object> params = new HashMap<>();
		params.put("mname", mname);
		params.put("mtel", mtel);
		
		String result = sqlSession.selectOne("findMyEmail", params);
		return result;
	}

	@Override
	public String findMyPw(String memail, String mtel) {
		Map<String, Object> params = new HashMap<>();
		params.put("memail", memail);
		params.put("mtel", mtel);
		
		String result = sqlSession.selectOne("findMyPw", params);
		return result;
	}

	@Override
	public int getUserMnum(String memail) {
		Map<String, Object> params = new HashMap<>();
		params.put("memail", memail);
		
		int result = sqlSession.selectOne("getUserMnum", params);
		return result;
	}

	@Override
	public JhMemberDto findUserInfoByMnum(String mnum) {
		return sqlSession.selectOne("findUserInfoByMnum", mnum);
	}

	@Override
	public void updateUserInfoByMnum(String mnum, JhMemberDto jhMemberDto) {
		Map<String, Object> params = new HashMap<>();
		params.put("mnum", mnum);
		params.put("jhMemberDto", jhMemberDto);
		
		sqlSession.update("updateUserInfoByMnum", params);
	}

	@Override
	public void deleteAccount(String mnum) {
		sqlSession.delete("deleteAccount", mnum);
	}

}