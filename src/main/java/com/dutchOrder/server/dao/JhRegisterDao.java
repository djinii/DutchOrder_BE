package com.dutchOrder.server.dao;

import com.dutchOrder.server.model.Member;

public interface JhRegisterDao {
	
    void insertC(Member jhMember);
	
	void insertB(Member jhMember);

	boolean isMnicDuplicate(String mnic);

	boolean isMemailDuplicate(String memail);

}
