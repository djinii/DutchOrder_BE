package com.dutchOrder.server.dao;

public interface JhLoginDao {
	
	boolean login(String memail, String mpw);

	int getUserLevel(String memail);
	
	String findMyEmail(String mname, String mtel);

	String findMyPw(String memail, String mtel);
}
