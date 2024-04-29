package com.dutchOrder.server.service;

import java.util.List;

import com.dutchOrder.server.model.Address;
import com.dutchOrder.server.model.Menu;
import com.dutchOrder.server.model.Shop;

public interface DJMainService {

	List<Shop> listShop(String fcategory_mikey);

	Shop shopInfo(String sname);

	Menu menuInfo(int fnum);

	List<Address> listAddr(int mnum);
	
	String getMtel(int mnum);

	List<Shop> listShops();

	List<Menu> listMenu(int bnum);
}
