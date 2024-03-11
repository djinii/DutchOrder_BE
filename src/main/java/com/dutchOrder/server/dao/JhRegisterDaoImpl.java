package com.dutchOrder.server.dao;

import com.dutchOrder.server.model.JhMember;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class JhRegisterDaoImpl implements JhRegisterDao {

    private final SqlSession sqlSession;

    public JhRegisterDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insert(JhMember jhMember) {
        try {
            System.out.println("JhRegisterDaoImpl insert Start...");
            sqlSession.insert("com.dutchOrder.server.dao.JhRegisterDao.insert", jhMember);
        } catch (Exception e) {
            // 예외 발생 시 로그 출력
            e.printStackTrace();
            // 클라이언트에게 오류 메시지 반환
            throw new RuntimeException("회원가입에 실패했습니다.");
        }

    }

	@Override
	public boolean existsByNickname(String mnic) {
		Boolean result = sqlSession.selectOne("com.dutchOrder.server.dao.JhRegisterDao.existsByNickname", mnic);
		System.out.println(result);
		return result != null && result;
	}
	
}
