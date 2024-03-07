package com.dutchOrder.server.service;

import com.dutchOrder.server.dao.JhMemberDao;
import com.dutchOrder.server.model.JhMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JhLoginServiceImpl implements JhLoginService {

    private final JhMemberDao memberDao;

    @Autowired
    public JhLoginServiceImpl(JhMemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public Map<String, Object> login(Map<String, Object> paramMap) {
        String memail = (String) paramMap.get("memail");
        String mpw = (String) paramMap.get("mpw");

        // 사용자 조회
        JhMember loggedInUser = memberDao.findUserByMemail(memail);

        if (loggedInUser != null) {
            // 아이디가 존재하는 경우에만 암호 확인
            if (loggedInUser.getMpw().equals(mpw)) {
                // 암호가 일치하는 경우 로그인 성공
                return convertMemberToMap(loggedInUser);
            } else {
                // 암호가 일치하지 않는 경우 로그인 실패
                return null;
            }
        } else {
            // 아이디가 존재하지 않는 경우 로그인 실패
            return null;
        }
    }


    // 사용자 객체를 Map 형태로 변환하는 메소드
    private Map<String, Object> convertMemberToMap(JhMember member) {
        // 필요한 사용자 정보를 Map 형태로 변환해서 반환
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", member.getName());
        userMap.put("memail", member.getMemail());
        // 사용자의 다른 정보도 필요한 경우 추가

        return userMap;
    }

	@Override
	public boolean checkIfIdExists(String memail) {
		// 데이터베이스에서 아이디 조회
	    JhMember member = memberDao.findUserByMemail(memail);
	    // 조회한 결과가 null이 아니면 아이디가 존재하는 것으로 판단
	    return member != null;
	}
}
