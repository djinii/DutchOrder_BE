package com.dutchOrder.server.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dutchOrder.server.model.Address;
import com.dutchOrder.server.model.Menu;
import com.dutchOrder.server.model.Review;
import com.dutchOrder.server.model.Shop;
import com.dutchOrder.server.model.Address;
import com.dutchOrder.server.service.DJMainService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class DJMainController {

	private final DJMainService ms;

	
	@GetMapping("/client/home")
	@ResponseBody
	public Map<String, Object> setMain(@RequestParam("mnum") String mnum, @RequestParam("x") String x, @RequestParam("y") String y){
		List<Address> myAddrList = null;
		List<Shop> nearbyShops = null;
		Map<String, Object> setMainData = new HashMap<>();
		
		try {

			myAddrList = ms.myAddrList(mnum);
			nearbyShops = ms.nearbyShops(Double.parseDouble(x), Double.parseDouble(y));
			
			setMainData.put("listAddr", myAddrList);
			setMainData.put("listShops", nearbyShops);
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
			System.out.println("---------");
			System.out.println("menus -> " + menus);
			
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
	
	// 회원이 새로운 주소를 추가했을때
	@PostMapping("/saving_oaddr")
	public void savingAddr(@RequestBody Address address) {
		try {
			ms.regAddress(address);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}
