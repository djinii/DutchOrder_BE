package com.dutchOrder.server.service;

import com.dutchOrder.server.dao.JhAuthDao;
import com.dutchOrder.server.dto.JhMemberDto;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JhAuthServiceImpl implements JhAuthService {
	
	private final JhAuthDao jhAuthDao;
    private final BCryptPasswordEncoder passwordEncoder;

	
    public JhAuthServiceImpl(JhAuthDao jhAuthDao, BCryptPasswordEncoder passwordEncoder) {
        this.jhAuthDao = jhAuthDao;
        this.passwordEncoder = passwordEncoder;
     }

    @Override
    public boolean login(String memail, String mpw) {
        // 데이터베이스에서 사용자의 암호화된 비밀번호를 가져옴
        String encryptedPassword = getEncryptedPassword(memail);
        
        // 사용자가 입력한 비밀번호를 BCrypt 알고리즘을 사용하여 해싱
        String hashedPassword = mpw;


        // 데이터베이스에서 가져온 비밀번호와 사용자가 입력한 비밀번호를 비교합니다.
        boolean result = BCrypt.checkpw(mpw, encryptedPassword);
        System.out.println("Passwords match: " + result);

        // 사용자가 입력한 비밀번호와 데이터베이스에서 가져온 암호화된 비밀번호 비교
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
	public String findMyPw(String memail, String mtel) {
		String result = jhAuthDao.findMyPw(memail, mtel);
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
	
}
