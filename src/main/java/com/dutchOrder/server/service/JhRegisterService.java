package com.dutchOrder.server.service;

import com.dutchOrder.server.model.Member;

public interface JhRegisterService {
	
    void insertC(Member Member);

	void insertB(Member Member);

	boolean isMnicDuplicate(String mnic);

	boolean isMemailDuplicate(String memail);

}
