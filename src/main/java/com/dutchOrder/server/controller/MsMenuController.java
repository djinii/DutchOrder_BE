package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.MsMenu;
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
	@GetMapping("/C_MRcardInf") // GET 요청을 처리할 수 있도록 수정
	@ResponseBody
	public List<MsMenu> addMenuList() {
		System.out.println("MsMenuController Start menuList ... ");
		List<MsMenu> msMenulist = ms.Menulist(); 
		System.out.println("MsMenuController List Menulist.size() -> " + msMenulist.size());
		return msMenulist;
	}
}
