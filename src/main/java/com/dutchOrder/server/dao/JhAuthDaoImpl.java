package com.dutchOrder.server.dao;

import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.dto.JhMemberDto;
import com.dutchOrder.server.model.JhMember;

@Repository
public class JhAuthDaoImpl implements JhAuthDao {
	
	private final SqlSession sqlSession;
    
    public JhAuthDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    
	@Override
    public boolean login(String memail, String mpw) {
		Map<String, Object> params = new HashMap<>();
		params.put("memail", memail);
		params.put("mpw", mpw);
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
	public int getUserMnum(String memail) {
		Map<String, Object> params = new HashMap<>();
		params.put("memail", memail);
		
		int result = sqlSession.selectOne("getUserMnum", params);
		return result;
	}
	
	@Override
	 public int getUserBnum(String memail) {
		 Map<String, Object> params = new HashMap<>();
			params.put("memail", memail);
		 
	     Integer result = sqlSession.selectOne("getUserBnum", params);
	     if (result == null) {
	    	 // 변환된 값이 null인 경우 예외를 throw하거나 적절한 기본값은 반환합니다
	    	 return -1;
	     }
	     return result.intValue();
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
	public void updateAccountStatus(String mnum) {
		sqlSession.update("updateAccountStatus", mnum);
	}

	@Override
	public String getEncryptedPassword(String memail) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("memail", memail);
	    return sqlSession.selectOne("getEncryptedPassword", params);
	}

	@Override
	public JhMemberDto findUserByMemail(String memail) {
		return sqlSession.selectOne("findUserByMemail", memail);
	}

	@Override
	public void updatePassword(JhMemberDto jhMemberDto) {
		sqlSession.update("updatePassword", jhMemberDto);
	}
	
}
