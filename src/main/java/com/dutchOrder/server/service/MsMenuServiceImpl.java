package com.dutchOrder.server.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.MsMenuDao;
import com.dutchOrder.server.model.MsMenu;
import com.dutchOrder.server.model.MsShop;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MsMenuServiceImpl implements MsMenuService {

	private final MsMenuDao md;

	@Override
	public List<MsShop> ShopCategoryLi() {
		System.out.println("EmpServiceImpl ShopCategoryLi Start...");
		List<MsShop> msShopList = md.ShopCategoryLi();
		return msShopList;
	}

	@Override
	public List<MsMenu> Menulist() {
		System.out.println("EmpServiceImpl MsMenulist Start...");
		List<MsMenu> menuList = md.MenuList();
		return menuList;
	}

}
