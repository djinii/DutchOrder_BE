package com.dutchOrder.server.service;

import com.dutchOrder.server.dao.JhAuthDao;
import com.dutchOrder.server.dto.JhMemberDto;
import com.dutchOrder.server.model.JhMember;

import lombok.RequiredArgsConstructor;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JhAuthServiceImpl implements JhAuthService {
	
	private final JhAuthDao jhAuthDao;
	
	@Override
	public boolean login(String memail, String mpw) {
		boolean result = jhAuthDao.login(memail, mpw);
		return result;
	}

	@Override
	public int getUserLevel(String memail) {
		int result = jhAuthDao.getUserLevel(memail);
		System.out.println(result);
		
		return result;
	}
	
	@Override
	public String findMyEmail(String mname, String mtel) {
		String result = jhAuthDao.findMyEmail(mname, mtel);
		System.out.println(result);
		return result;
	}

	@Override
	public String findMyPw(String memail, String mtel) {
		String result = jhAuthDao.findMyPw(memail, mtel);
		System.out.println(result);
		return result;
	}

	@Override
	public int getUserMnum(String memail) {
		int result = jhAuthDao.getUserMnum(memail);
		System.out.println(result);
		return result;
	}





}
