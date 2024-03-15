package com.dutchOrder.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.MwEmailModel;
import com.dutchOrder.server.service.MwEmailService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MwEmailController {

	private final MwEmailService mes;
	
	@ResponseBody
	@PostMapping("/sendVerificationEmail")
    public ResponseEntity<String> sendVerificationEmail(@RequestBody MwEmailModel email) {
		// 이메일 전송 로직
		System.out.println("MwEmailController sendVerificationEmail Start...");
		String sendEmail = email.getEmail();
        try {
            mes.sendEmail(sendEmail);
            return ResponseEntity.ok("이메일이 성공적으로 전송되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            // HttpStatus.INTERNAL_SERVER_ERROR는 서버측 오류로 HTTP 상태 코드 500을 뜻함, body는 본문에 해당하는 에러메시지
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("이메일 전송 중 오류가 발생했습니다.");
        }
    }
	
	@ResponseBody
	@PostMapping("/confirmVerificationCode")
	public ResponseEntity<String> confirmVerificationCode(@RequestBody MwEmailModel mwEmailModel) {
		// 이메일 인증코드 확인 로직
		System.out.println("MwEmailController confirmVerificationCode Start...");
		int result = 0;
		try {
			result = mes.confirmEc(mwEmailModel);
			if(result != 0)
				return ResponseEntity.ok("인증이 완료되었습니다.");
			else 
				return ResponseEntity.ok("인증이 실패하였습니다.");
		} catch(Exception e) {
			System.out.println("MwEmailController confirmVerificationCode Exception->"+e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("오류가 발생했습니다.");
		}
	}
	
}