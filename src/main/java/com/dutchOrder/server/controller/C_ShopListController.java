package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.dutchOrder.server.model.Shop;
import com.dutchOrder.server.service.C_MainService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class C_ShopListController {
	
	private final C_MainService ms;
	
	@GetMapping("/shoplist")
	public List<Shop> getShopList(@RequestParam("category") String fcategory_mikey) {
		System.out.println("controller Start...");
		
		List<Shop> listShop = ms.listShop(fcategory_mikey);
		System.out.println("controller listShop.size() -> " + listShop.size());
		
		return listShop;
	}
}
