
package com.dutchOrder.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.MsMenu;
import com.dutchOrder.server.model.MsShop;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MsMenuDaoImpl implements MsMenuDao {

	// MyBatis DB 연동
	private final SqlSession session;


@Override
public List<MsShop> ShopCategoryLi() {
	System.out.println("MsMenuDaoImpl ShopCategoryLi Start...");
	List<MsShop> shopList = null;
	try {
		shopList = session.selectList("msShopList");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
	return shopList;
}

@Override
public List<MsMenu> MenuList() {
	System.out.println("MsMenuDaoImpl MenuList Start...");
	List<MsMenu> menuList = null;
	try {
		menuList = session.selectList("msMenuList");
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return menuList;
}
}
