package com.dutchOrder.server.service;

import com.dutchOrder.server.model.JhMember;

public interface JhRegisterService {
	
    void insertC(JhMember jhMember);

	void insertB(JhMember jhMember);

	boolean isMnicDuplicate(String mnic);

	boolean isMemailDuplicate(String memail);

}