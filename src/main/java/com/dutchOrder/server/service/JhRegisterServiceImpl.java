package com.dutchOrder.server.service;

import java.lang.reflect.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.JhRegisterDao;
import com.dutchOrder.server.model.JhMember;

@Service
public class JhRegisterServiceImpl implements JhRegisterService {
    
    @Autowired
    private JhRegisterDao jhRegisterDao;
    
    @Override
    public void insertC(JhMember jhMember) {
    	jhRegisterDao.insertC(jhMember);
    }

    @Autowired
    public JhRegisterServiceImpl(JhRegisterDao jhRegisterDao) {
    	this.jhRegisterDao = jhRegisterDao;
    }
    

	@Override
	public void insertB(JhMember jhMember) {
		jhRegisterDao.insertB(jhMember);
		
	}

	@Override
	public boolean isMnicDuplicate(String mnic) {
		boolean result = jhRegisterDao.isMnicDuplicate(mnic);
		return result;
	}

	@Override
	public boolean isMemailDuplicate(String memail) {
		boolean result = jhRegisterDao.isMemailDuplicate(memail);
		return result;
	}


}
