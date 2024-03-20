package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dutchOrder.server.model.Address;
import com.dutchOrder.server.model.Menu;
import com.dutchOrder.server.model.Shop;
import com.dutchOrder.server.service.DJMainService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class DJMainController {

	private final DJMainService ms;
	
	@GetMapping("/client/home")
	List<Address> getUserAddr(@CookieValue("mnum") int mnum){
		System.out.println("MainController - /main");
		List<Address> listAddr = null;
		listAddr = ms.listAddr(mnum);

		return listAddr;
	}
	
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
		
		System.out.println(shopInfo + "[controller]  shop 나 여기???");
		return shopInfo;
	}
	
	@GetMapping("/item/itemView")
	public Menu getMenuInfo(@RequestParam("f") String fname) {
		System.out.println("[controller] getMenuInfo ~ " + fname);

		Menu menuInfo = ms.menuInfo(fname);
		System.out.println(menuInfo+"       controller");
		return menuInfo;
	}
}
