package com.dutchOrder.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.Address;
import com.dutchOrder.server.model.Menu;
import com.dutchOrder.server.model.SearchCriteria;
import com.dutchOrder.server.model.Shop;

import jakarta.websocket.OnClose;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DJMainDaoImpl implements DJMainDao {
	
	private final SqlSession session;
	
	// 사용안함
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
		
		List<Menu> menus = null;
		try {
			menus = session.selectList("mapMenuList",bnum);			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return menus;
	}
	@Override
	public Menu menuInfo(int fnum) {
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

	
	
	@Override
	public String getMtel(int mnum) {
		String mtel = "";
		try {
			mtel =session.selectOne("mapMtel",mnum);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		
		}
		return mtel;
	}
	@Override
	public List<Shop> listShops() {
		List<Shop> listShops = null;
		System.out.println("dao start...");
		try {
			listShops = session.selectList("mapAllShopList");
			System.out.println("[dao] sucess get list from Mybatis -> " +listShops);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return listShops;
	}
	
	
	//------------------------------------------------------------------------------------------------
	// adnum 생성
	@Override
	public String createAdNum(int mnum) {					
		String adnum = null;
		try {
			adnum = session.selectOne("createAdNum", mnum);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return adnum;
	}
	
	// 회원 주소 저장
	@Override
	public int regAddress(Address address) {					
		int result = 0;
		try {
			result = session.insert("regAddress", address);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	// 회원의 주소 리스트
	@Override
	public List<Address> myAddrList(String mnum) {
		List<Address> myAddrList = null;
		try {
			myAddrList = session.selectList("myAddrList", mnum);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return myAddrList;
	}
	
	// 배달주소 주변 가게 리스트
	@Override
	public List<Shop> nearbyShops(SearchCriteria searchCriteria){
		List<Shop> nearbyShops = null;
		try {
			nearbyShops = session.selectList("nearbyShops", searchCriteria);
			System.out.println("nearbyShops   >>>>>>>.  " + nearbyShops);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return nearbyShops;
	}
	
	
}
