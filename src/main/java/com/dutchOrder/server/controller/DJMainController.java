package com.dutchOrder.server.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
//	@GetMapping("/client/home")
//	List<Address> getUserAddr(@CookieValue("mnum") int mnum){
//		System.out.println("MainController - /main");
//		List<Address> listAddr = null;
//		List<Shop> listShops = null;
//		try {
//			listAddr = ms.listAddr(mnum);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//
//		return listAddr;
//	}
	
	@GetMapping("/client/home")
	public Map<String, Object> setMain(@CookieValue("mnum") int mnum){
		List<Address> listAddr = null;
		List<Shop> listShops = null;
		Map<String, Object> setMainData = new HashMap<>();
		
		try {
			listAddr = ms.listAddr(mnum);
			listShops = ms.listShops();
			
			setMainData.put("listAddr", listAddr);
			setMainData.put("listShops", listShops);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return setMainData;
	}
	
	@GetMapping("/client/shoplist")
//	@GetMapping("/client/home")
	public List<Shop> getShopList(@RequestParam("category") String fcategory_mikey) {
		System.out.println("[controller] getShopList Start... => " + fcategory_mikey );
		
		List<Shop> listShop = ms.listShop(fcategory_mikey);
		System.out.println("controller listShop.size() -> " + listShop.size());
		
		return listShop;
	}
	
	
//	@GetMapping("/client/shopInfo")
	@GetMapping("/")
	public Shop getShopInfo(@RequestParam("spec") String sname) {
		System.out.println("[controller] getShopInfo ~ " + sname);
		
		Shop shopInfo = ms.shopInfo(sname);
		
		System.out.println(shopInfo + "[controller]  shop 나 여기???");
		return shopInfo;
	}
	
	@GetMapping("/client/shopInfo")
	public Map<String, Object> getShop(@RequestParam("spec") String sname) {
		System.out.println("[controller] getShop ~ " + sname);
		Map<String, Object> shopMap = new HashMap<>();
		
		Shop shopInfo = null; 
		List<Menu> menus = null;
		
		try {
			shopInfo = ms.shopInfo(sname);
			menus = ms.listMenu(shopInfo.getBnum());
			
			shopMap.put("shopInfo", shopInfo);
			shopMap.put("menus", menus);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		System.out.println(shopInfo + "[controller]  shop 나 여기???");
		return shopMap;
	}
	
	@GetMapping("/client/shopInfo/itemView")
	public Menu getMenuInfo(@RequestParam("fdeT") String fnumStr) {
		System.out.println("[controller] getMenuInfo ~ " + fnumStr);
		
		
		int fnum = (Integer.parseInt(fnumStr, 16))/100;
		System.out.println("[controller] getMenuInfo ~ " + fnum);
		Menu menuInfo = ms.menuInfo(fnum);
		System.out.println(menuInfo+"       controller");
		return menuInfo;
	}
}
