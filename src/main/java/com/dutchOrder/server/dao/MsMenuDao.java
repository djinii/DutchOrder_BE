package com.dutchOrder.server.dao;

import java.util.List;

import com.dutchOrder.server.model.Menu;
import com.dutchOrder.server.model.Shop;

public interface MsMenuDao {

	List<Menu> MenuList();

	Shop getShopStatus(int sstatus_mikey);

	List<Shop> ShopCategoryLi();

	Shop getShopDetail(int mnum);

	int adMenuInsert(Menu msMenu);

	int ShopTimeUpdate(Shop msShop);


	int reMenuUpdate(Menu msMenu);

	int deleteMenu(int fnum);

	int updateShopStatus(Shop msShop);

	Shop getshopAccept(int mnum);

	int RegShop(Shop msShop);

	Shop getBFileDetail(int mnum);

	int bFileInsert(Shop msShop);


	List<Menu> MenuDetail(int bnum);

	boolean isSnameDuplicate(String sname);

	boolean isBidDuplicate(String bid);



}
