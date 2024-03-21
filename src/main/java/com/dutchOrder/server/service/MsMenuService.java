package com.dutchOrder.server.service;

import java.util.List;

import com.dutchOrder.server.model.Menu;
import com.dutchOrder.server.model.Shop;

public interface MsMenuService {

	List<Menu> Menulist();

	List<Shop> ShopCategoryLi();

	Shop ShopDetail(int mnum);

	int updateShopTimeUpdate(Shop msShop);

	int adMenuInsert(Menu msMenu);


	int reMenuUpdate(Menu msMenu);

	int deleteMenu(int fnum);

	Shop getShopStatus(int sstatus_mikey);

	int updateShopStatus(Shop msShop);

	Shop getshopAccept(int mnum);

	int RegShop(Shop msShop);

	Shop getFileDetail(int mnum);

	int InsertBfile(Shop msShop);

	List<Menu> DetailMenu(int bnum);

	boolean issnameDuplicate(String sname);

	boolean isBidDuplicate(String bid);




}
