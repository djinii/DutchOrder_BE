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
    
    @Autowired
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
    

	@PostMapping("/getUserBnum")
	public int getUserBnum(@RequestBody Map<String, String> request) {
		String memail = request.get("memail");
	    System.out.println("memail: " + memail);

	    int result = jhAuthService.getUserBnum(memail);
	    System.out.println("/getUserBnum(bnum): " + result);
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
    
    @PutMapping("/updateAccountStatus/{mnum}")
    public ResponseEntity<?> updateAccountStatus(@PathVariable("mnum") String mnum) {
    	try {
			jhAuthService.updateAccountStatus(mnum);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("계정 삭제 중 오류 발생");
		}
    }
    
    @PostMapping("/updatePassword")
    public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> requestBody) {
        String memail = requestBody.get("memail");
        String newPassword = requestBody.get("newPassword");

        String result = jhAuthService.updatePassword(memail, newPassword);
        if (result.equals("Success")) {
            return ResponseEntity.ok("Password updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
    
    
