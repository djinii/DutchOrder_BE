package com.dutchOrder.server.service;

import com.dutchOrder.server.dao.JhAuthDao;
import com.dutchOrder.server.dto.JhMemberDto;
import com.dutchOrder.server.model.JhMember;

import org.apache.catalina.User;
import org.apache.ibatis.javassist.NotFoundException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JhAuthServiceImpl implements JhAuthService {
	
	private final JhAuthDao jhAuthDao;

	    private final BCrypt bCrypt;

	    public JhAuthServiceImpl(JhAuthDao jhAuthDao, BCrypt bCrypt) {
	        this.jhAuthDao = jhAuthDao;
	        this.bCrypt = bCrypt;
	    }
	   
	    @Override
	    public boolean login(String memail, String mpw) {
	        String encryptedPassword = getEncryptedPassword(memail);
	        System.out.println("encryptedPassword: " + encryptedPassword);
	        boolean result = BCrypt.checkpw(mpw, encryptedPassword);
	        System.out.println("Passwords match: " + result);
	        return result;
	    }

		@Override
		public int getUserLevel(String memail) {
			int result = jhAuthDao.getUserLevel(memail);
			return result;
		}
		
		@Override
		public String findMyEmail(String mname, String mtel) {
			String result = jhAuthDao.findMyEmail(mname, mtel);
			return result;
		}
	
		@Override
		public int getUserMnum(String memail) {
			int result = jhAuthDao.getUserMnum(memail);
			return result;
		}
	
		@Override
		public JhMemberDto findUserInfoByMnum(String mnum) {
			return jhAuthDao.findUserInfoByMnum(mnum);
		}
	
		@Override
		public void updateUserInfo(String mnum, JhMemberDto jhMemberDto) {
			jhAuthDao.updateUserInfoByMnum(mnum, jhMemberDto);
		}
	
		@Override
		public void updateAccountStatus(String mnum) {
			jhAuthDao.updateAccountStatus(mnum);
		}
	
		@Override
		public String getEncryptedPassword(String memail) {
			return jhAuthDao.getEncryptedPassword(memail);
		}
	
		@Override
		public String updatePassword(String memail, String newPassword) {
			  JhMemberDto jhMemberDto = jhAuthDao.findUserByMemail(memail);
		        if (jhMemberDto != null) {
		            jhMemberDto.setPassword(newPassword);
		            jhAuthDao.updatePassword(jhMemberDto);
		            return "Success";
		        } else {
		            return "User not found";
		        }
		    }
		}
	