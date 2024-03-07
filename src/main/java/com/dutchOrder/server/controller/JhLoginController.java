package com.dutchOrder.server.controller;

import com.dutchOrder.server.model.JhMember;
import com.dutchOrder.server.service.JhLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.HashMap;
import java.util.Map;

@RestController
public class JhLoginController {

    private final JhLoginService jhLoginService;

    @Autowired
    public JhLoginController(JhLoginService jhLoginService) {
        this.jhLoginService = jhLoginService;
    }
    
    // 로그인 성공시 홈화면으로 이동하지만 개인과 사업자 계정에 따라 나눠야 함 (추후)
   

    @PostMapping("/api/login/{level}")
    public ResponseEntity<?> login(@PathVariable("level") String level, @RequestBody Map<String, Object> requestMap) {
        try {
            Map<String, Object> loggedInUser = jhLoginService.login(requestMap);
            if (loggedInUser != null) {
                // 로그인 성공 시 OK 응답 반환
                return ResponseEntity.status(HttpStatus.OK).body(loggedInUser);
            } else {
                // 로그인 실패 시 실패 이유에 따라 다른 응답 반환
                boolean isIdExist = jhLoginService.checkIfIdExists(requestMap.get("memail").toString());
                if (!isIdExist) {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("존재하지 않는 아이디입니다");
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("암호를 확인해주세요");
                }
            }
        } catch (Exception e) {
            // 실패 이유를 알 수 있는 예외 처리
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }


    @GetMapping("{level}/home")
    public String success() {
        // 로그인 성공 시 보여줄 페이지
        return "successPage";
    }

    @GetMapping("{level}/login")
    public String login() {
        // 로그인 실패 시 보여줄 로그인 페이지
        return "loginPage";
    }
}
