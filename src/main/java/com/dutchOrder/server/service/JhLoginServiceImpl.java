package com.dutchOrder.server.service;

import com.dutchOrder.server.dao.JhLoginDao;
import com.dutchOrder.server.model.JhMember;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JhLoginServiceImpl implements JhLoginService {
	
	private final JhLoginDao jhLoginDao;
	
	@Override
	public boolean login(String memail, String mpw) {
		boolean result = jhLoginDao.login(memail, mpw);
		return result;
	}

	@Override
	public int getUserLevel(String memail) {
		int result = jhLoginDao.getUserLevel(memail);
		return result;
	}

}
