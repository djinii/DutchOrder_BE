package com.dutchOrder.server.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
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
	List<Address> getUserAddr(@CookieValue("mnum") int mnum){
		System.out.println("MainController - /main");
		List<Address> listAddr = null;
		listAddr = ms.listAddr(mnum);

		return listAddr;
	}
}
