package com.dutchOrder.server.dao;

import java.util.List;

import com.dutchOrder.server.model.*;
public interface DJMainDao {

	List<Shop> listShop(String fcategory_mikey);	// 해당하는 카테고리의 리스트 꺼내기

	Shop shopInfo(String sname);

	List<Menu> listMenu(int bnum);

	Menu menuInfo(int fnum);

	
	String getMtel(int mnum);

	List<Shop> listShops();

	
	
	String createAdNum(int mnum); 							// address.adnum 생성
	int regAddress(Address address);						// 회원의 주소 저장 
	List<Address> myAddrList(String mnum);					// 회원의 주소 리스트
	
	List<Shop> nearbyShops(SearchCriteria searchCriteria);	// 주변 가게 리스트
	
}
