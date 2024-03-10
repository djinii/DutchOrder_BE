package com.dutchOrder.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.JhRegisterDao;
import com.dutchOrder.server.model.JhMember;

@Service
public class JhRegisterServiceImpl implements JhRegisterService {
    
    @Autowired
    private JhRegisterDao jhRegisterDao;
    
    @Override
    public void insert(JhMember jhMember) {
    	jhRegisterDao.insert(jhMember);
    }

    @Autowired
    public JhRegisterServiceImpl(JhRegisterDao jhRegisterDao) {
    	this.jhRegisterDao = jhRegisterDao;
    }
    
    // 닉네임 중복 확인 
	@Override
	public boolean checkDuplicates(String mnic) {
		return jhRegisterDao.existsByNickname(mnic);
	}


}
