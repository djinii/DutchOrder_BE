 package com.dutchOrder.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

		@ResponseBody
		@PostMapping("/connectTest")
		public String test() {
			System.out.println("CartController");
		    return "connected";
		}
		
		
}
