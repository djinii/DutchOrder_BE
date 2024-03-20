package com.dutchOrder.server.dao;

import java.util.List;

import com.dutchOrder.server.model.*;
public interface DJMainDao {

	List<Shop> listShop(String fcategory_mikey);	// 해당하는 카테고리의 리스트 꺼내기

	Shop shopInfo(String sname);

	List<Menu> listMenu(int bnum);

	Menu menuInfo(String fnum);

	List<Address> listAddr(int mnum);
	
	String getMtel(int mnum);
}
