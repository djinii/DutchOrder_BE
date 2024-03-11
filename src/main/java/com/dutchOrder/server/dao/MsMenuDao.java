package com.dutchOrder.server.dao;

import java.util.List;
import java.util.Map;

import com.dutchOrder.server.model.MsMenu;
import com.dutchOrder.server.model.MsShop;

public interface MsMenuDao {

	List<MsMenu> MenuList();

	int getShopStatus(int sstatus_mikey);

	List<MsShop> ShopCategoryLi();

	MsShop getShopDetail(int bnum);

	// String updateShopTimeUpdate(MsShop msShop);

	int adMenuInsert(MsMenu msMenu);

	int ShopTimeUpdate(MsShop msShop);
}
