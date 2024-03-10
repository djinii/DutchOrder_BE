package com.dutchOrder.server.controller;

import com.dutchOrder.server.model.JhMember;
import com.dutchOrder.server.service.JhLoginService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
}
