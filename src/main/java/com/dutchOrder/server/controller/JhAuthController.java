package com.dutchOrder.server.controller;

import com.dutchOrder.server.dto.JhMemberDto;
import com.dutchOrder.server.service.JhAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class JhAuthController {

    @Autowired
    private JhAuthService jhAuthService;


    public JhAuthController(JhAuthService jhAuthService) {
        this.jhAuthService = jhAuthService;
    }
    
    @PostMapping("/login")
    public boolean login(@RequestBody Map<String, String> request) {
    	
    	System.out.println(request);
    	String memail = request.get("memail");
    	String mpw = request.get("mpw");    
    	System.out.println(memail + mpw);
    	
    	boolean result = jhAuthService.login(memail,mpw);
    	return result;
    }
    
    @PostMapping("/getUserLevel")
    public int getUserLevel(@RequestBody Map<String, String> request) {
    	
    	String memail = request.get("memail");
    	System.out.println("memail" + memail);
    	
    	int result = jhAuthService.getUserLevel(memail);
    	System.out.println("/getUserLevel(mgroup_mikey)" + result);
    	return result;
    }
    
    @PostMapping("/getUserMnum")
    public int getUserMnum(@RequestBody Map<String, String> request) {
    	
    	String memail = request.get("memail");
    	System.out.println("memail" + memail);
    	
    	int result = jhAuthService.getUserMnum(memail);
    	System.out.println("/getUserMnum(mnum)" + result);
    	return result;
    }
    
    @PostMapping("/findMyEmail")
    public String findMyEmail(@RequestBody Map<String, String> request) {
    	
    	System.out.println(request);
    	String mname = request.get("mname");
    	String mtel = request.get("mtel");
    	System.out.println(mname + mtel);
    	
    	String result = jhAuthService.findMyEmail(mname, mtel);
    	return result;
    }
    
    @PostMapping("/findMyPw")
    public String findMyPw(@RequestBody Map<String, String> request) {
    	
    	String memail = request.get("memail");
    	String mtel = request.get("mtel");
    	
    	String result = jhAuthService.findMyPw(memail, mtel);
    	return result;
    }
    
    // mnum 으로 바인딩하라고 경로 변수를 지정해줌 
    @GetMapping("/updateInfo/{mnum}")
    public ResponseEntity<JhMemberDto> getUserInfo(@PathVariable("mnum") String mnum) {
    	
    	JhMemberDto jhMemberDto = jhAuthService.findUserInfoByMnum(mnum);
    	return ResponseEntity.ok(jhMemberDto);
    }
    
    @PutMapping("/updateInfo/{mnum}")
    public ResponseEntity<?> updateUserInfo(@PathVariable("mnum") String mnum, @RequestBody JhMemberDto jhMemberDto) {
    	jhAuthService.updateUserInfo(mnum, jhMemberDto);
    	return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/deleteAccount/{mnum}")
    public ResponseEntity<?> deleteUser(@PathVariable("mnum") String mnum) {
    	try {
			jhAuthService.deleteAccount(mnum);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("계정 삭제 중 오류 발생");
		}
    }
    
}
    
    