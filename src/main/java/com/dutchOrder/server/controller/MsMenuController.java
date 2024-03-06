package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.MsShop;
import com.dutchOrder.server.service.MsMenuService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MsMenuController {

	private final MsMenuService ms;
	
	// 가게 내용
	@GetMapping("/C_ShopCard")
	@ResponseBody
	public List<MsShop> addShopCategoryLi()  {
		System.out.println("MsMenuController Start shopCategoryLi ... ");
		
		List<MsShop> resShopCategoryLi = ms.ShopCategoryLi(); 
		
		System.out.println("MsMenuController List Menulist.size() -> " + resShopCategoryLi.size());
		
		return resShopCategoryLi;
		
	}
	

	// 메뉴 내용 
//	@GetMapping(value = "/C_MenuCard") // GET 요청을 처리할 수 있도록 수정
//	@ResponseBody
//	public List<MsMenu> menuList(MsMenu msMenu) {
//		System.out.println("MsMenuController Start menuList ... ");
//		List<MsMenu> msMenulist = ms.MsMenulist(msMenu); // POST 요청의 경우 파라미터로 받아올 필요가 없으므로 삭제
//		System.out.println("MsMenuController List Menulist.size() -> " + msMenulist.size());
//		return msMenulist;
//	}

	@GetMapping("/enuCard") // GET 요청을 처리할 수 있도록 수정
	public String test() {
		return "success";
	}

	// 가게 내용 가져오기
//	@GetMapping("/C_ShopInf")
//	public List<MsShop> shopList() {
//		System.out.println("MsMenuController Start shopList ... ");
//		
//		return new SomeData();
//	}
	@ResponseBody
	@PostMapping("/connectTest")
	public String test1() {
		System.out.println("CartController");
		return "connected";
	}
}
