package com.dutchOrder.server.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.MwEmailDao;
import com.dutchOrder.server.model.MwEmailModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MwEmailServiceImpl implements MwEmailService {
	@Autowired
	private JavaMailSender mailSender;	// 이메일을 전송하는데 사용되는 객체
	
	private final MwEmailDao med;
	private static final int CODE_LENGTH = 6; // 인증 코드 길이
    private static final String HASH_ALGORITHM = "SHA-256"; // 해시 알고리즘
	
	@Override
	public void sendEmail(String email) {
		System.out.println("MwEmailServiceImpl sendEmail Start...");
		System.out.println("sendEmail email->"+email);
		// 이메일메시지 인스턴스 생성
		SimpleMailMessage message = new SimpleMailMessage();
		// 이메일 수신자 주소 설정
		message.setTo(email);
		// 이메일 제목 설정
		message.setSubject("더치오더 이메일 인증");
		// 인증코드 생성 메소드 실행
		String eccode = sendCode();
		// 이메일 본문 내용 설정
		message.setText("인증 코드: "+eccode);
		// 이메일메시지를 자바메일을 통해 전송
		mailSender.send(message);
		med.ecSave(email, eccode);
	}

	private String sendCode() {
		// 인증코드 생성 로직
		try {
			// 예측할 수 없는 난수를 생성하기 위한 클래스 인스턴스
            SecureRandom secureRandom = new SecureRandom();
            // 길이가 16인 바이트 배열 생성
            byte[] randomBytes = new byte[16];
            // 무작위로 바이트를 생성하여 randomBytes에 할당
            secureRandom.nextBytes(randomBytes);
            System.out.println("randomBytes[]-->"+randomBytes);
            
            // 해시 값을 계산하기 위해 사용되는 클래스
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            // randomBytes의 데이터를 해싱하고 반환값을 hashBytes배열에 저장
            byte[] hashBytes = digest.digest(randomBytes);
            System.out.println("hashBytes[]-->"+hashBytes);
            
            // 16진수 문자열을 저장하기 위한 객체 생성
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hashBytes.length; i++) {
            	// 해시된 바이트를 16진수 문자열로 변환
                String hex = Integer.toHexString(0xff & hashBytes[i]);
                System.out.println("hex-->"+hex);
                // 문자열이 한자리인 경우 0을 붙여 두자리로 만들어줌
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
                System.out.println("hexString--->"+hexString);
            }
            return hexString.substring(0, CODE_LENGTH); // 6자리 인증 코드로 변환
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("sendCode NoSuchAlgorithmException->"+e.getMessage());
            return "인증코드 생성 에러"; // 예외 처리
        }
    }

	@Override
	public int confirmEc(MwEmailModel mwEmailModel) {
		// 인증코드 확인
		System.out.println("MwEmailServiceImpl confirmEc Start...");
		int result = 0;
		result = med.confirmEc(mwEmailModel);
		
		return result;
	}
	
}