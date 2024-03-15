package com.dutchOrder.server.service;

import org.apache.catalina.User;

import com.dutchOrder.server.dto.JhMemberDto;

public interface JhAuthService {
	
	boolean login(String memail, String mpw);

	int getUserLevel(String memail);
	

	String findMyEmail(String mname, String mtel);

	String findMyPw(String memail, String mtel);

	int getUserMnum(String memail);

	JhMemberDto findUserInfoByMnum(String mnum);

	void updateUserInfo(String mnum, JhMemberDto jhMemberDto);

	void deleteAccount(String mnum);

}