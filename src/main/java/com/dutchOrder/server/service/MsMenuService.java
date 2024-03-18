package com.dutchOrder.server.service;

import java.util.List;

import com.dutchOrder.server.model.MsMenu;
import com.dutchOrder.server.model.MsShop;

public interface MsMenuService {

	List<MsMenu> Menulist();

	List<MsShop> ShopCategoryLi();

	MsShop ShopDetail(int mnum);

	int updateShopTimeUpdate(MsShop msShop);

	int adMenuInsert(MsMenu msMenu);

	List<MsMenu> MenuInfo(int bnum);

	int reMenuUpdate(MsMenu msMenu);

	int deleteMenu(int fnum);

	MsShop getShopStatus(int sstatus_mikey);

	int updateShopStatus(MsShop msShop);

	MsShop getshopAccept(int mnum);

	int RegShop(MsShop msShop);

	MsShop getFileDetail(int mnum);

	int InsertBfile(MsShop msShop);

	int getUserBnum(int mnum);



}
