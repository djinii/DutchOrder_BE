
package com.dutchOrder.server.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

//	@Override
//	public List<String> ShopCategoryLi(int fcategory_mikey) {
//	    List<String> shopCategoryLi = new ArrayList<>();
//	    // 이제 sname, start_time, end_time을 사용할 수 있습니다.
//	    System.out.println("MsMenuDaoImpl ShopCategoryLi Start...");
//
//	    try {
//	        System.out.println(fcategory_mikey);
//	        List<Map<String, String>> result = session.selectList("mapShopCategoryLi", fcategory_mikey);
//	        System.out.println("!!!!!!!!!");
//	        System.out.println("MsMenuDaoImpl shopCategoryLi result size -> " + result.size());
//
//	        for (Map<String, String> row : result) {
//	            String sname = row.get("sname");
//	            String start_time = row.get("start_time");
//	            String end_time = row.get("end_time");
//	            String shopInfo = sname + ", " + start_time + ", " + end_time;
//	            shopCategoryLi.add(shopInfo);
//	        }
//	    } catch (Exception e) {
//	        System.out.println("MsMenuDaoImpl shopCategoryLi Exception->" + e.getMessage());
//	    }
//	    return shopCategoryLi;
//	}


//		메뉴 불러오는 .. <미완>
	@Override
	public List<MsMenu> MsSelectMenu(MsMenu msMenu) {
		List<MsMenu> menuList = null;
		System.out.println("MsMenuDaoImpl MsSelectMenu Start...");
		try {
			menuList = session.selectList("MsSelectMenu", msMenu);
			System.out.println("MsMenuDaoImpl menuList menuList.size() -> " + menuList.size());

		} catch (Exception e) {
			System.out.println("MsMenuDaoImpl MsSelectMenu Exception->" + e.getMessage());
		}
		return menuList;
	}

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
}
