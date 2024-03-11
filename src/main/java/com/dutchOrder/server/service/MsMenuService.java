package com.dutchOrder.server.service;

import java.util.List;

import com.dutchOrder.server.model.MsMenu;
import com.dutchOrder.server.model.MsShop;

public interface MsMenuService {


	List<MsMenu> Menulist();

	int getShopStatus(int sstatus_mikey);

	List<MsShop> ShopCategoryLi();

	MsShop ShopDetail(int bnum);

	int updateShopTimeUpdate(MsShop msShop);

	int adMenuInsert(MsMenu msMenu);

}
