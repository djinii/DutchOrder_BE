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
	public MsShop ShopDetail(int mnum) {
		System.out.println("MsMenuServiceImpl ShopCategoryLi Start...");
		MsShop shop = md.getShopDetail(mnum);
		return shop;
	}

	@Override
	public List<MsShop> ShopCategoryLi() {
		System.out.println("MsMenuServiceImpl ShopCategoryLi Start...");
		List<MsShop> msShopList = md.ShopCategoryLi();
		return msShopList;
	}

	@Override
	public List<MsMenu> Menulist() {
		System.out.println("MsMenuServiceImpl MsMenulist Start...");
		List<MsMenu> menuList = md.MenuList();
		return menuList;
	}


	@Override
	public List<MsMenu> DetailMenu(int bnum) {
		List<MsMenu> msMenu = null;
		System.out.println("MsMenuServiceImpl DetailMenu Start...");
		System.out.println("MsMenuServiceImpl DetailMenu bnum -> " + bnum);
		msMenu = md.MenuDetail(bnum);
		System.out.println("MsMenuServiceImpl DetailMenu msMenu -> " + msMenu);
		
		return msMenu;
	}
	

	@Override
	public MsShop getShopStatus(int sstatus_mikey) {
		System.out.println("MsMenuServiceImpl getShopStatus Start...");
		MsShop shopStatus = md.getShopStatus(sstatus_mikey);
		return shopStatus;
	}

	@Override
	public int updateShopTimeUpdate(MsShop msShop) {
		int timeUpdate = 0;
		System.out.println("MsMenuServiceImpl MsMenulist Start...");
		timeUpdate = md.ShopTimeUpdate(msShop);
		return timeUpdate;
	}

	@Override
	public int adMenuInsert(MsMenu msMenu) {
		int adMenuInsert = 0;
		System.out.println("MsMenuServiceImpl adMenuInsert Start...");
		adMenuInsert = md.adMenuInsert(msMenu);

		return adMenuInsert;
	}


	@Override
	public int reMenuUpdate(MsMenu msMenu) {
		int reMenuUpdate = 0;
		System.out.println("MsMenuServiceImpl reMenuUpdate Start...");
		reMenuUpdate = md.reMenuUpdate(msMenu);

		return reMenuUpdate;
	}

	@Override
	public int deleteMenu(int fnum) {
		int MenuDelete = 0;
		System.out.println("MsMenuServiceImpl deleteMenu Start...");
		MenuDelete = md.deleteMenu(fnum);

		return MenuDelete;
	}

	@Override
	public int updateShopStatus(MsShop msShop) {
		int updateShopStatus = 0;
		System.out.println("MsMenuServiceImpl updateShopStatus Start...");
		updateShopStatus = md.updateShopStatus(msShop);

		return updateShopStatus;
	}

	@Override
	public MsShop getshopAccept(int mnum) {
		System.out.println("MsMenuServiceImpl getshopAccept Start...");
		MsShop getshopAccept = md.getshopAccept(mnum);
		return getshopAccept;
	}

	@Override
	public int RegShop(MsShop msShop) {
		int ShopReg = 0;
		System.out.println("MsMenuServiceImpl RegShop Start...");
		ShopReg = md.RegShop(msShop);

		return ShopReg;
	}

	@Override
	public MsShop getFileDetail(int mnum) {
		System.out.println("MsMenuServiceImpl getFileDetail Start...");
		MsShop msShop = md.getBFileDetail(mnum);
		return msShop;
	}

	@Override
	public int InsertBfile(MsShop msShop) {
		int bFileInsert = 0;

		System.out.println("MsMenuServiceImpl RegShop Start...");
		bFileInsert = md.bFileInsert(msShop);

		return bFileInsert;
	}

	@Override
	public boolean issnameDuplicate(String sname) {
		boolean result = md.isSnameDuplicate(sname);
		return result;
	}

	@Override
	public boolean isBidDuplicate(String bid) {
		boolean result = md.isBidDuplicate(bid);
		return result;
	}





}
