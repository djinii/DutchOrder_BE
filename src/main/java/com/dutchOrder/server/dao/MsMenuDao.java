package com.dutchOrder.server.dao;

import java.util.List;
import java.util.Map;

import com.dutchOrder.server.model.MsMenu;
import com.dutchOrder.server.model.MsShop;

public interface MsMenuDao {


	List<MsMenu> MsSelectMenu(MsMenu msMenu);


	List<MsShop> ShopCategoryLi();



}
