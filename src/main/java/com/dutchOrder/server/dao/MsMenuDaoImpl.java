
package com.dutchOrder.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.Menu;
import com.dutchOrder.server.model.Shop;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MsMenuDaoImpl implements MsMenuDao {

	// MyBatis DB 연동
	private final SqlSession session;

	/** bnum에 따른 가게 정보 */
	@Override
	public Shop getShopDetail(int mnum) {
		System.out.println("MsMenuDaoImpl getShopDetail Start...");
		Shop shopList = null;
		try {
			shopList = session.selectOne("mapShopDetailByMnum", mnum);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("가게 정보를 가져오는 데 실패했습니다.", e);
		}
		return shopList;
	}

	@Override
	public List<Shop> ShopCategoryLi() {
		System.out.println("MsMenuDaoImpl ShopCategoryLi Start...");
		List<Shop> shopList = null;
		try {
			shopList = session.selectList("mapShopDetail");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return shopList;
	}

	@Override
	public List<Menu> MenuList() {
		System.out.println("MsMenuDaoImpl MenuList Start...");
		List<Menu> menuList = null;
		try {
			menuList = session.selectList("msMenuList");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return menuList;
	}
	
	@Override
	public List<Menu> MenuDetail(int bnum) {
		List<Menu> msMenu = null;
		try {
			System.out.println("사업자 번호: "+bnum);
			msMenu = session.selectList("mapMenuDetailBybnum", bnum);
			System.out.println("MsMenuDaoImpl MenuDetail getBnum -> " + bnum);
		} catch (Exception e) {
			System.out.println("MsMenuDaoImpl MenuDetail Exception -> " + e.getMessage());
		}
		
		return msMenu;
	}
	


	@Override
	public Shop getShopStatus(int sstatus_mikey) {
		System.out.println("MsMenuDaoImpl ShopStatus Start...");
		Shop msShop = new Shop();
		try {
			// mapper ID, Parameter
			msShop = session.selectOne("mapGetShopStatus", sstatus_mikey);
			System.out.println("MsMenuDaoImpl shopStatus getSstatus_mikey->" + msShop.getSstatus_mikey());

		} catch (Exception e) {
			System.out.println("MsMenuDaoImpl shopStatus Exception->" + e.getMessage());
		}
		return msShop;
	}

	/** bnum에 따라서 시간 업데이트되게하기 */
	@Override
	public int ShopTimeUpdate(Shop msShop) {
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

	/** 메뉴추가하기 */
	@Override
	public int adMenuInsert(Menu msMenu) {
		System.out.println("MsMenuDaoImpl adMenuInsert start..");
		int MenuInsert = 0;
		try {
			MenuInsert = session.insert("mapMenuInsert", msMenu);
		} catch (Exception e) {
			System.out.println("MsMenuDaoImpl adMenuInsert Exception -> " + e.getMessage());
		}

		return MenuInsert;
	}



	@Override
	public int reMenuUpdate(Menu msMenu) {
		System.out.println("MsMenuDaoImpl reMenuUpdate start..");
		int MenuUpdate = 0;
		try {
			MenuUpdate = session.update("mapMenuUpdate", msMenu);
		} catch (Exception e) {
			System.out.println("MsMenuDaoImpl reMenuUpdate Exception -> " + e.getMessage());
		}

		return MenuUpdate;
	}

	@Override
	public int deleteMenu(int fnum) {
		System.out.println("MsMenuDaoImpl deleteMenu Start...");
		int MenuDelete = 0;
		try {
			MenuDelete = session.delete("mapMemuDelete", fnum);
		} catch (Exception e) {
			System.out.println("MsMenuDaoImpl deleteMenu Exception -> " + e.getMessage());
		}

		return MenuDelete;
	}

	@Override
	public int updateShopStatus(Shop msShop) {
		System.out.println("MsMenuDaoImpl ShopStausUpdate start..");
		int ShopStausUpdate = 0;
		try {
			ShopStausUpdate = session.update("mapShopStatusUpdate", msShop);
		} catch (Exception e) {
			System.out.println("MsMenuDaoImpl ShopStausUpdate Exception -> " + e.getMessage());
		}

		return ShopStausUpdate;
	}

	@Override
	public Shop getshopAccept(int mnum) {
		System.out.println("MsMenuDaoImpl getshopAccept Start...");
		Shop msShop = new Shop();
		try {
			msShop = session.selectOne("mapMsgetMemberStatus", mnum);
			System.out.println("MsMenuDaoImpl getshopAccept getMnum->" + msShop.getMnum());

		} catch (Exception e) {
			System.out.println("MsMenuDaoImpl getshopAccept Exception->" + e.getMessage());
		}
		return msShop;
	}

	@Override
	public int RegShop(Shop msShop) {
		System.out.println("MsMenuDaoImpl RegShop Start...");
		System.out.println("MsMenuDaoImpl RegShop msShop->" + msShop);
		int ShopReg = 0;
		try {
			// System.out.println("MsMenuDaoImpl RegShop msShop!!!!!!!!!!!!!!->"+msShop);
			ShopReg = session.insert("mapMsShopReg", msShop);
		} catch (Exception e) {
			System.out.println("MsMenuDaoImpl RegShop Exception -> " + e.getMessage());
		}

		return ShopReg;
	}

	@Override
	public Shop getBFileDetail(int mnum) {
		System.out.println("MsMenuDaoImpl getBFileDetail Start...");
		Shop ListShop = null;
		try {
			ListShop = session.selectOne("mapBFileSelect", mnum);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("MsMenuDaoImpl getBFileDetail Exception -> " + e.getMessage());
		}
		return ListShop;
	}

	@Override
	public int bFileInsert(Shop msShop) {
		System.out.println("MsMenuDaoImpl bFileInsert Start...");
		System.out.println("MsMenuDaoImpl bFileInsert msShop->" + msShop);
		int bFileInsert = 0;
		try {
			// System.out.println("MsMenuDaoImpl RegShop msShop!!!!!!!!!!!!!!->"+msShop);
			bFileInsert = session.insert("mapBFileInsert", msShop);
		} catch (Exception e) {
			System.out.println("MsMenuDaoImpl bFileInsert Exception -> " + e.getMessage());
		}

		return bFileInsert;
	}

	@Override
	public boolean isSnameDuplicate(String sname) {
		Integer count = session.selectOne("findSnameCount", sname);
        return count != null && count > 0;
	}

	@Override
	public boolean isBidDuplicate(String bid) {
		Integer count = session.selectOne("findBidCount", bid);
        return count != null && count > 0;
	}





}