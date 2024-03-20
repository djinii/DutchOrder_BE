package com.dutchOrder.server.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dutchOrder.server.model.CartReq;
import com.dutchOrder.server.model.Order;
import com.dutchOrder.server.service.C_OrderService;

import lombok.RequiredArgsConstructor;
//
//
@RestController
@RequiredArgsConstructor
public class C_OrderController {
	
	private final C_OrderService os;
	
	@GetMapping("/ordPlaced")
	public String getMtel(@CookieValue("mnum") int mnum) {
		System.out.println("dao start -> " + mnum);
		String mtel = "";
		try {
			mtel = os.getMtel(mnum);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mtel;
		
		
	}
	
	
//	// void 해도될
//	@PostMapping("/ordPlaced")
//	public String setOrdering(@RequestBody CartReq req) {
//		System.out.print("cartController~~ ");
//		System.out.println(req.getMnum() + " 회원");
//		System.out.println(req.getOaddr() + " 주소");
//		System.out.println(req.getCart() + " 카트 ");
//		// ordering 저장
//		// order_spec 저장
//		
//		int mnum = req.getMnum();
//		String oaddr = req.getOaddr();
//		List<CartInfo> cart = req.getCart();
//		
////		os.setOrdering(req);
//		
//		return "sucess";
//	}
	
	 @PostMapping("/ordPlaced")
	    public String setOrdering(@RequestBody CartReq req, @CookieValue("mnum") int mnum) {
	        System.out.print("cartController~~ ");
	        System.out.println(mnum + " 회원");
	        
	        System.out.println(" cart " + req.getCart());
	        // ordering 저장
	        // order_spec 저장

//	        String oaddr = req.getOaddr();

	        os.setOrdering(req, mnum);
	         System.out.println(" return controller");

	        return "success";
	    }
}

