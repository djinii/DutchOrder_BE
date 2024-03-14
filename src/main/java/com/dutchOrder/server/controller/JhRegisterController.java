package com.dutchOrder.server.controller;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dutchOrder.server.dto.JhMemberDto;
import com.dutchOrder.server.model.JhMember;
import com.dutchOrder.server.service.JhRegisterService;

@RestController
public class JhRegisterController {

    @Autowired
    private JhRegisterService jhRegisterService;

    @PostMapping("/client/join")
    public ResponseEntity<String> registerClient(@RequestBody JhMember jhMember) {
        try {
            // 회원 정보를 저장합니다.
            jhRegisterService.insertC(jhMember);
            return ResponseEntity.ok("회원가입이 완료되었습니다.");
        } catch (Exception e) {
            // 에러가 발생한 경우 에러 메시지를 반환합니다.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입에 실패했습니다.");
        }
    }
    
    @PostMapping("/business/join")
    public ResponseEntity<String> registerBusiness(@RequestBody JhMember jhMember) {
        try {
            // 회원 정보를 저장합니다.
            jhRegisterService.insertB(jhMember);
            return ResponseEntity.ok("회원가입이 완료되었습니다.");
        } catch (Exception e) {
            // 에러가 발생한 경우 에러 메시지를 반환합니다.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입에 실패했습니다.");
        }
    }
    
    // 닉네임 중복 확인 
    @GetMapping("/check-duplicate/mnic")
    public ResponseEntity<?> checkMnicDuplicate(@RequestParam("mnic") String mnic){
    	boolean isDuplicate = jhRegisterService.isMnicDuplicate(mnic);
    	System.out.println(mnic);
    	return ResponseEntity.ok().body(Map.of("isDuplicate", isDuplicate));
    }
    
    // 이메일 중복 확인
    @GetMapping("/check-duplicate/memail")
    public ResponseEntity<?> checkMemailDuplicate(@RequestParam("memail") String memail) {
    	boolean isDuplicate = jhRegisterService.isMemailDuplicate(memail);
    	System.out.println(memail);
    	return ResponseEntity.ok().body(Map.of("isDuplicate", isDuplicate));
    			
    }
    
    

    
}