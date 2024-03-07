package com.dutchOrder.server.service;

import java.util.Map;

import com.dutchOrder.server.model.JhMember;

public interface JhLoginService {

	Map<String, Object> login(Map<String, Object> paramMap);

	boolean checkIfIdExists(String string);

}
