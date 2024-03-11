package com.dutchOrder.server.service;

import com.dutchOrder.server.dao.JhLoginDao;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

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

	@Override
	public String findMyEmail(String mname, String mtel) {
		String result = jhLoginDao.findMyEmail(mname, mtel);
		return result;
	}

	@Override
	public String findMyPw(String memail, String mtel) {
		String result = jhLoginDao.findMyPw(memail, mtel);
		return result;
	}

}
