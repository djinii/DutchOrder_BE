package com.dutchOrder.server.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dutchOrder.server.model.Address;
import com.dutchOrder.server.service.C_MainService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class C_MainController {
	
	private final C_MainService ms;
	
	@GetMapping("/main")
	List<Address> getUserAddr(HttpServletRequest request){
		System.out.println("MainController - /main");
		List<Address> listAddr = null;
		Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("mnum")) {
                    String mnum = cookie.getValue();
                    System.out.println(mnum+" controller");
                    listAddr = ms.listAddr(mnum); // mnum에 해당하는 데이터를 가져옴
                }
            }
        }
		return listAddr;
	}
}
