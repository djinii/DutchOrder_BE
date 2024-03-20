package com.dutchOrder.server.service;

import java.util.List;

import com.dutchOrder.server.model.Address;
import com.dutchOrder.server.model.Menu;
import com.dutchOrder.server.model.Shop;


public interface C_MainService {
	List<Shop> listShop(String fcategory_mikey);

	Shop shopInfo(String sname);

	Menu menuInfo(String fname);

	List<Address> listAddr(int mnum);
}
