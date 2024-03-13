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
	   public MsShop ShopDetail(int bnum) {
	      System.out.println("EmpServiceImpl ShopCategoryLi Start...");
	      MsShop shop = md.getShopDetail(bnum);
	      return shop;
	   }
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

	@Override
	public int getShopStatus(int sstatus_mikey) {
		System.out.println("EmpServiceImpl MsMenulist Start...");
		int shopStatus = md.getShopStatus(sstatus_mikey);
		return shopStatus;
	}
	
	@Override
	public int  updateShopTimeUpdate(MsShop msShop) {
		int timeUpdate =0;
	    System.out.println("EmpServiceImpl MsMenulist Start...");
	    timeUpdate  = md.ShopTimeUpdate(msShop);
	    return timeUpdate;
	}


	@Override
	public int adMenuInsert(MsMenu msMenu) {
		int adMenuInsert = 0;
		System.out.println("EmpServiceImpl adMenuInsert Start...");
		adMenuInsert = md.adMenuInsert(msMenu);
		
		return adMenuInsert;
	}
	@Override
	public List<MsMenu> MenuInfo(int bnum) {
		System.out.println("EmpServiceImpl MenuInfo Start...");
		List<MsMenu> msMenulist = md.MenuInfo(bnum); 
	      return msMenulist;
	}

	@Override
	public int reMenuUpdate(MsMenu msMenu) {
		int reMenuUpdate = 0;
		System.out.println("EmpServiceImpl reMenuUpdate Start...");
		reMenuUpdate = md.reMenuUpdate(msMenu);
		
		return reMenuUpdate;
	}
		
	@Override
	public int deleteMenu(int fnum) {
		int MenuDelete = 0;
		System.out.println("NoticeServiceImpl deleteNotice Start...");
		MenuDelete = md.deleteMenu(fnum);
		
		return MenuDelete;
	}
	

}
