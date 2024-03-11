package com.dutchOrder.server.dao;

import java.util.List;

import org.antlr.v4.runtime.misc.TestRig;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.Menu;
import com.dutchOrder.server.model.Shop;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class C_MainDaoImpl implements C_MainDao {
	
	private final SqlSession session;
	
	@Override
	public List<Shop> listShop(String fcategory_mikey) {
		
		List<Shop> shopList = null;
		System.out.println("dao start...");
		try {
			shopList = session.selectList("mapShopList",fcategory_mikey);
			System.out.println("sucess get list from Mybatis");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return shopList;
	}
	@Override
	public Shop shopInfo(String sname) {
		Shop shopInfo = null;
		System.out.println("dao start... shopInfo");
		try {
			shopInfo = session.selectOne("mapShopInfo",sname);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return shopInfo;
	}
	
	@Override
	public List<Menu> listMenu(int bnum){
		
		List<Menu> listMenu = null;
		try {
			listMenu = session.selectList("mapMenuList",bnum);			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return listMenu;
	}
	@Override
	public Menu menuInfo(String fnum) {
		Menu menuInfo = null;
		System.out.println("dao_menuInfo");
		try {
			menuInfo = session.selectOne("mapMenuInfo", fnum);
			System.out.println("menuinfo --> " + menuInfo);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return menuInfo;
		
	}
}
