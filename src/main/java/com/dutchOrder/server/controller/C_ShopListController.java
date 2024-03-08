package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.dutchOrder.server.model.Shop;
import com.dutchOrder.server.service.C_MainService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
public class C_ShopListController {
	
	private final C_MainService ms;
	
	@GetMapping("/shoplist")
	public List<Shop> getShopList(@RequestParam("category") String fcategory_mikey) {
		System.out.println("[controller] getShopList Start...");
		
		List<Shop> listShop = ms.listShop(fcategory_mikey);
		System.out.println("controller listShop.size() -> " + listShop.size());
		
		return listShop;
	}
	
	@GetMapping("/shopInfo")
	public Shop getShopInfo(@RequestParam("spec") String sname) {
		System.out.println("[controller] getShopInfo ~ " + sname);
		
		Shop shopInfo = ms.shopInfo(sname);
	
		return shopInfo;
	}
	
	
}
