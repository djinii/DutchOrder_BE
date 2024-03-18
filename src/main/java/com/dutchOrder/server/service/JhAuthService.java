package com.dutchOrder.server.service;

import org.apache.catalina.User;
import org.apache.ibatis.javassist.NotFoundException;

import com.dutchOrder.server.dto.JhMemberDto;

public interface JhAuthService {
	
	boolean login(String memail, String mpw);

	int getUserLevel(String memail);

	String findMyEmail(String mname, String mtel);

	int getUserMnum(String memail);

	JhMemberDto findUserInfoByMnum(String mnum);

	void updateUserInfo(String mnum, JhMemberDto jhMemberDto);

	void updateAccountStatus(String mnum);

	String getEncryptedPassword(String memail);

	String updatePassword(String memail, String newPassword);

}