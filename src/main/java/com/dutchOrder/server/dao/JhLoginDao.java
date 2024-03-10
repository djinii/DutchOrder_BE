package com.dutchOrder.server.dao;

import com.dutchOrder.server.model.JhMember;

public interface JhLoginDao {
	
	boolean login(String memail, String mpw);

	int getUserLevel(String memail);

}
