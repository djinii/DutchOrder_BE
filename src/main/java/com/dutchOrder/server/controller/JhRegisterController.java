package com.dutchOrder.server.controller;

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

    @PostMapping("/api/client/join")
    public ResponseEntity<String> registerUser(@RequestBody JhMember jhMember) {
        try {
            // 회원 정보를 저장합니다.
            jhRegisterService.insert(jhMember);
            return ResponseEntity.ok("회원가입이 완료되었습니다.");
        } catch (Exception e) {
            // 에러가 발생한 경우 에러 메시지를 반환합니다.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입에 실패했습니다.");
        }
    }
    
    // 닉네임 중복 확인
    @PostMapping("/api/check-duplicates")
    public ResponseEntity<Boolean> checkDuplicates(@RequestBody JhMemberDto jhMemberDto) {
    	boolean isDuplicate = jhRegisterService.checkDuplicates(jhMemberDto.getMnic());
    	return ResponseEntity.ok(isDuplicate);
    }
    
    
}
