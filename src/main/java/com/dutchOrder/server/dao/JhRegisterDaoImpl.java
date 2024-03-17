package com.dutchOrder.server.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.JhMember;

@Repository
public class JhRegisterDaoImpl implements JhRegisterDao {

    private final SqlSession sqlSession;

    public JhRegisterDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insertC(JhMember jhMember) {
        try {
            System.out.println("JhRegisterDaoImpl insertC Start...");
            sqlSession.insert("com.dutchOrder.server.dao.JhRegisterDao.insertC", jhMember);
        } catch (Exception e) {
            // 예외 발생 시 로그 출력
            e.printStackTrace();
            // 클라이언트에게 오류 메시지 반환
            throw new RuntimeException("회원가입에 실패했습니다.");
        }

    }


	@Override
	public void insertB(JhMember jhMember) {
		 try {
	            System.out.println("JhRegisterDaoImpl insertB Start...");
	            sqlSession.insert("com.dutchOrder.server.dao.JhRegisterDao.insertB", jhMember);
	        } catch (Exception e) {
	            // 예외 발생 시 로그 출력
	            e.printStackTrace();
	            // 클라이언트에게 오류 메시지 반환
	            throw new RuntimeException("회원가입에 실패했습니다.");
	        }		
	}

	@Override
	public boolean isMnicDuplicate(String mnic) {
		Integer count = sqlSession.selectOne("com.dutchOrder.server.dao.JhRegisterDao.findMnicCount", mnic);
        return count != null && count > 0;
    }

    @Override
    public boolean isMemailDuplicate(String memail) {
        Integer count = sqlSession.selectOne("com.dutchOrder.server.dao.JhRegisterDao.findMemailCount", memail);
        return count != null && count > 0;
    }
}