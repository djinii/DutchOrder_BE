package com.dutchOrder.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.JhMemberDao;
import com.dutchOrder.server.model.JhMember;

@Service
public class JhRegisterService {
	
	@Autowired
	private JhMemberDao jhMemberDao;
	
	public void save(JhMember jhMember) {
		jhMemberDao.save(jhMember);
	}

}
