package com.dutchOrder.server.dao;

import java.util.List;
import java.util.Map;

import com.dutchOrder.server.model.MsMenu;
import com.dutchOrder.server.model.MsShop;

public interface MsMenuDao {

	List<MsMenu> MenuList();

	MsShop getShopStatus(int sstatus_mikey);

	List<MsShop> ShopCategoryLi();

	MsShop getShopDetail(int mnum);

	int adMenuInsert(MsMenu msMenu);

	int ShopTimeUpdate(MsShop msShop);


	int reMenuUpdate(MsMenu msMenu);

	int deleteMenu(int fnum);

	int updateShopStatus(MsShop msShop);

	MsShop getshopAccept(int mnum);

	int RegShop(MsShop msShop);

	MsShop getBFileDetail(int mnum);

	int bFileInsert(MsShop msShop);


	List<MsMenu> MenuDetail(int bnum);

	boolean isSnameDuplicate(String sname);

	boolean isBidDuplicate(String bid);



}
