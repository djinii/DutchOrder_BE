package com.dutchOrder.server.dao;

import com.dutchOrder.server.model.JhMember;

public interface JhRegisterDao {
	
    void insert(JhMember jhMember);

	boolean existsByNickname(String mnic);

}
