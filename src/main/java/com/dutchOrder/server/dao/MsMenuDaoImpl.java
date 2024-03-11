
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

	/** bnum에 따른 가게 정보 */
	@Override
	public MsShop getShopDetail(int bnum) {
		System.out.println("MsMenuDaoImpl getShopDetail Start...");
		MsShop shopList = null;
		try {
			shopList = session.selectOne("mapShopDetailBybnum", bnum);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("가게 정보를 가져오는 데 실패했습니다.", e);
		}
		return shopList;
	}

	@Override
	public List<MsShop> ShopCategoryLi() {
		System.out.println("MsMenuDaoImpl ShopCategoryLi Start...");
		List<MsShop> shopList = null;
		try {
			shopList = session.selectList("mapShopDetail");
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

	@Override
	public int getShopStatus(int sstatus_mikey) {
		System.out.println("MsMenuDaoImpl ShopStatus Start...");
		int shopStatus = 0; // 가게 상태 초기값 설정
		try {
			// mapper ID, Parameter
			MsShop msShop = session.selectOne("mapGetShopStatus", sstatus_mikey);
			if (msShop != null) {
				shopStatus = msShop.getSstatus_mikey(); // 가게 상태 값 설정
				System.out.println("EmpDaoImpl shopStatus getSstatus_mikey->" + shopStatus);
			}
		} catch (Exception e) {
			System.out.println("EmpDaoImpl detail Exception->" + e.getMessage());
		}
		return shopStatus;
	}

	/** bnum에 따라서 시간 업데이트되게하기 */
	@Override
	public int ShopTimeUpdate(MsShop msShop) {
	    System.out.println("MsMenuDaoImpl updateShopTimeUpdate start..");
	    int updatedRows = 0;
	    try {
	        updatedRows = session.update("updateShopTime", msShop);
	    } catch (Exception e) {
	        System.out.println("updateShopTimeUpdate Exception->" + e.getMessage());
	        e.printStackTrace();
	    }
	    return updatedRows;
	}


	
	@Override
	public int adMenuInsert(MsMenu msMenu) {
		 System.out.println("MsMenuDaoImpl adMenuInsert start..");
		 int MenuInsert = 0;
			try {
				MenuInsert = session.insert("mapMenuInsert", msMenu);
			} catch (Exception e) {
				System.out.println("MsMenuDaoImpl adMenuInsert Exception -> " + e.getMessage());
			}
			
			return MenuInsert;
	}

}