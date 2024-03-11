package com.dutchOrder.server.controller;

import com.dutchOrder.server.service.JhLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class JhLoginController {

    private final JhLoginService jhLoginService;

    @Autowired
    public JhLoginController(JhLoginService jhLoginService) {
        this.jhLoginService = jhLoginService;
    }
    
    @PostMapping("/login")
    public boolean login(@RequestBody Map<String, String> request) {
    	
    	System.out.println(request);
    	String memail = request.get("memail");
    	String mpw = request.get("mpw");
    	System.out.println(memail + mpw);
    	
    	boolean result = jhLoginService.login(memail,mpw);
    	return result;
    }
    
    @PostMapping("/getUserLevel")
    public int getUserLevel(@RequestBody Map<String, String> request) {
    	
    	String memail = request.get("memail");
    	System.out.println(memail);
    	
    	int result = jhLoginService.getUserLevel(memail);
    	System.out.println(result);
    	return result;
    }
    
    @PostMapping("/findMyEmail")
    public String findMyEmail(@RequestBody Map<String, String> request) {
    	
    	System.out.println(request);
    	String mname = request.get("mname");
    	String mtel = request.get("mtel");
    	System.out.println(mname + mtel);
    	
    	String result = jhLoginService.findMyEmail(mname, mtel);
    	return result;
    }
    
    @PostMapping("/findMyPw")
    public String findMyPw(@RequestBody Map<String, String> request) {
    	System.out.println(request);
    	String memail = request.get("memail");
    	String mtel = request.get("mtel");
    	System.out.println(memail + mtel);
    	
    	String result = jhLoginService.findMyPw(memail, mtel);
    	return result;
    }
    
}
