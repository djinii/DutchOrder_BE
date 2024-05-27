package com.dutchOrder.server.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dutchOrder.server.model.CartReq;
import com.dutchOrder.server.model.Order;
import com.dutchOrder.server.service.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DJOrderController {
	
	private final DJOrderService os;
	private final DJMainService ms;
	
	@GetMapping("/ordPlaced")
	public String getMtel(@CookieValue("mnum") int mnum) {
		System.out.println("OrderService Controller start -> " + mnum);
		String mtel = "";
		try {
			mtel = ms.getMtel(mnum);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mtel;	
	}
	
	@PostMapping("/client/ordPlaced")
    public int setOrdering(@RequestBody CartReq req, @CookieValue("mnum") int mnum) {
		int onum = 0;
		try {
			
			System.out.print("cartController~~ ");
			onum = os.setOrdering(req, mnum);
		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return onum;
	} 

}