package com.dutchOrder.server.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.MwEmailDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MwEmailServiceImpl implements MwEmailService {
	@Autowired
	private JavaMailSender mailSender;
	private final MwEmailDao med;
	private static final int CODE_LENGTH = 6; // 인증 코드 길이
    private static final String HASH_ALGORITHM = "SHA-256"; // 해시 알고리즘
	
	@Override
	public void sendEmail(String email) {
		System.out.println("MwEmailServiceImpl sendEmail Start...");
		System.out.println("sendEmail email->"+email);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("더치오더 이메일 인증");
		String eccode = sendCode();
		message.setText("인증 코드: "+eccode);
		mailSender.send(message);
		med.ecSave(email, eccode);
	}

	private String sendCode() {
		try {
            SecureRandom secureRandom = new SecureRandom();
            byte[] randomBytes = new byte[16];
            secureRandom.nextBytes(randomBytes);

            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] hashBytes = digest.digest(randomBytes);

            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hashBytes.length; i++) {
                String hex = Integer.toHexString(0xff & hashBytes[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.substring(0, CODE_LENGTH); // 6자리 인증 코드로 변환
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("sendCode NoSuchAlgorithmException->"+e.getMessage());
            return null; // 예외 처리
        }
    }
	
}
