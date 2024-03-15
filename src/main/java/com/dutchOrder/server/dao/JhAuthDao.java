package com.dutchOrder.server.dao;

import com.dutchOrder.server.dto.JhMemberDto;
import com.dutchOrder.server.model.JhMember;

public interface JhAuthDao {
	
	boolean login(String memail, String mpw);

	int getUserLevel(String memail);
	
	String findMyEmail(String mname, String mtel);

	String findMyPw(String memail, String mtel);

	int getUserMnum(String memail);
	
	JhMemberDto findUserInfoByMnum(String mnum);

	void updateUserInfoByMnum(String mnum, JhMemberDto jhMemberDto);

	void updateAccountStatus(String mnum);

	String getEncryptedPassword(String memail);

}
