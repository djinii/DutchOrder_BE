package com.dutchOrder.server.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import com.dutchOrder.server.model.JhMember;
import com.dutchOrder.server.service.JhRegisterService;

@RestController
public class JhRegisterController {

    private final JhRegisterService jhRegisterService;
    
    public JhRegisterController(JhRegisterService jhRegisterService) {
        this.jhRegisterService = jhRegisterService;
    }
    
    // 회원가입 시 비밀번호 해시화
    private String hashPassword(String mpw) {
        return BCrypt.hashpw(mpw, BCrypt.gensalt());
    }
    
    @PostMapping("/client/join")
    public ResponseEntity<String> registerClient(@RequestBody JhMember jhMember) {
        try {
        	 // 비밀번호를 BCrypt로 해시화
            String hashedPassword = hashPassword(jhMember.getMpw());
            jhMember.setMpw(hashedPassword);
        	
            jhRegisterService.insertC(jhMember);
            return ResponseEntity.ok("회원가입이 완료되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입에 실패했습니다.");
        }
    }

    @PostMapping("/business/join")
    public ResponseEntity<String> registerBusiness(@RequestBody JhMember jhMember) {
        try {
            
        	// 비밀번호를 BCrypt로 해시화
            String hashedPassword = hashPassword(jhMember.getMpw());
            jhMember.setMpw(hashedPassword);
            
            jhRegisterService.insertB(jhMember);
            return ResponseEntity.ok("회원가입이 완료되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입에 실패했습니다.");
        }
    }
    
    // 닉네임 중복 확인 
    @GetMapping("/check-duplicate/mnic")
    public ResponseEntity<?> checkMnicDuplicate(@RequestParam("mnic") String mnic){
        boolean isDuplicate = jhRegisterService.isMnicDuplicate(mnic);
        return ResponseEntity.ok().body(Map.of("isDuplicate", isDuplicate));
    }
    
    // 이메일 중복 확인
    @GetMapping("/check-duplicate/memail")
    public ResponseEntity<?> checkMemailDuplicate(@RequestParam("memail") String memail) {
        boolean isDuplicate = jhRegisterService.isMemailDuplicate(memail);
        return ResponseEntity.ok().body(Map.of("isDuplicate", isDuplicate));
                
    }
}
    
