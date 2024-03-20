package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.EmailRequest;
import com.dutchOrder.server.model.PaymentInfo;
import com.dutchOrder.server.service.MwPaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MwPaymentController {
	
	private final MwPaymentService paymentService;
	
	@Autowired
    private JavaMailSender javaMailSender;

	@ResponseBody
    @PostMapping("/api/paymentInfo")
    public ResponseEntity<List<PaymentInfo>> getPaymentInfo(@RequestBody PaymentInfo paymentInfo) {
    	System.out.println("결제컨트롤러 결제정보받아오기 시작...");
    	int onum = paymentInfo.getOnum();
    	System.out.println("주문번호: "+onum);
        List<PaymentInfo> paymentInfoList = paymentService.getPaymentInfo(onum);
        System.out.println("받아온 결제정보리스트: "+paymentInfoList.toString());
        return ResponseEntity.ok(paymentInfoList);
    }

    @ResponseBody
    @PostMapping("/api/sendEmail")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
    	System.out.println("결제컨트롤러 이메일전송 시작...");
    	System.out.println("보낼정보: "+emailRequest);
    	try {
    		// 간단한 이메일 메시지 생성
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailRequest.getTo());
            message.setSubject(emailRequest.getSubject());
            message.setText(emailRequest.getBody());
            
            // 이메일 보내기
            javaMailSender.send(message);

            return "Email sent successfully";
    	} catch(Exception e) {
    		System.out.println("결제컨트롤러 이메일전송 익셉션: "+e.getMessage());
    		return "Failed to send email";
    	}
    }
    
    @PostMapping("/api/payResult")
    public String payResult(@RequestBody PaymentInfo paymentInfo) {
    	System.out.println("결제컨트롤러 결제결과 업데이트 시작...");
    	int onum = paymentInfo.getOnum();
    	String mname = paymentInfo.getMname();
    	System.out.println("주문번호: "+onum+", 이름: "+mname);
    	paymentService.payResult(paymentInfo);
    	
    	return "payResult success";
    }

	
	
	
	
	
	
	
	
	

	
}
