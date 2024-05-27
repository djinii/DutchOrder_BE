package com.dutchOrder.server.service;

import java.sql.Timestamp;
import java.util.List;

import com.dutchOrder.server.model.Address;
import com.dutchOrder.server.model.Menu;
import com.dutchOrder.server.model.Shop;

public interface DJMainService {

	List<Shop> listShop(String fcategory_mikey);

	Shop shopInfo(String sname);

	Menu menuInfo(int fnum);

	
	String getMtel(int mnum);

	List<Shop> listShops();

	List<Menu> listMenu(int bnum);
	
	//---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- //
	int regAddress(Address address);						// 회원의 주소 저장 
	List<Address> myAddrList(String mnum);					// 회원의 주소 리스트
	
	List<Shop> nearbyShops(Double x, Double y);	// 주변 가게 리스트
	
}