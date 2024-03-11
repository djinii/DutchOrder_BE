package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.C_MainDaoImpl;
import com.dutchOrder.server.model.Menu;
import com.dutchOrder.server.model.Shop;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class C_MainServiceImpl implements C_MainService {

	private final C_MainDaoImpl md;
	
	@Override
	public List<Shop> listShop(String fcategory_mikey) {
		// TODO Auto-generated method stub
		System.out.println("Service start...");
		
		 List<Shop> shopList = md.listShop(fcategory_mikey);
		 System.out.println("Service listShop.size() -> " + shopList.size());
		 
		return shopList;
	}

	@Override
	public Shop shopInfo(String sname) {
		System.out.println("[serveice] start ~~~ ");
		Shop shopInfo = md.shopInfo(sname);
		shopInfo.setCntLi(1); // 나중에 dao의 노티스 컨트롤러로 가져와야함 (리뷰수)
		shopInfo.setMenuList(md.listMenu(shopInfo.getBnum()));  // 가게 메뉴를 객체에 추가
		
		return shopInfo;
	}

	@Override
	public Menu menuInfo(String fnum) {
		
		System.out.println("[Service] menuInfo ~~");
		Menu menuInfo = md.menuInfo(fnum);
		
		System.out.println("[Service] menuInfo ~~"+ menuInfo);
		
		return menuInfo;
	}

}
