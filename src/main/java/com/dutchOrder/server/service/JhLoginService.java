package com.dutchOrder.server.service;

import java.util.Map;

import com.dutchOrder.server.model.JhMember;

public interface JhLoginService {
	
	boolean login(String memail, String mpw);

	int getUserLevel(String memail);
	
}
