
package com.dutchOrder.server.dao;

import com.dutchOrder.server.model.JhMember;

public interface JhRegisterDao {
	
    void insertC(JhMember jhMember);
	
	void insertB(JhMember jhMember);

	boolean isMnicDuplicate(String mnic);

	boolean isMemailDuplicate(String memail);

}
