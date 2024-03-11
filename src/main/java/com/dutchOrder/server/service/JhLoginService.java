package com.dutchOrder.server.service;

public interface JhLoginService {
	
	boolean login(String memail, String mpw);

	int getUserLevel(String memail);

	String findMyEmail(String mname, String mtel);

	String findMyPw(String memail, String mtel);
	
}
