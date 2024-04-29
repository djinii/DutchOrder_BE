package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.DJMainDao;
import com.dutchOrder.server.model.*;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DJMainServiceImpl implements DJMainService {
	
	private final DJMainDao md;
	
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
//		shopInfo.setCntLi(1); // 나중에 dao의 노티스 컨트롤러로 가져와야함 (리뷰수)
		shopInfo.setMenuList(md.listMenu(shopInfo.getBnum()));  // 가게 메뉴를 객체에 추가
		
		return shopInfo;
	}

	@Override
	public Menu menuInfo(int fnum) {
		
		System.out.println("[Service] menuInfo ~~");
		Menu menuInfo = md.menuInfo(fnum);
		
		System.out.println("[Service] menuInfo ~~"+ menuInfo);
		
		return menuInfo;
	}

	@Override
	public List<Address> listAddr(int mnum) {
		System.out.println(mnum + "mainService +  " + mnum);
		List<Address> listAddr = md.listAddr(mnum);
		System.out.println("finished  listAddr --> " + listAddr);
		return listAddr;
	}
	
	@Override
	public String getMtel(int mnum) {
		System.out.println("service -----> " + mnum);
		String mtel="";
		mtel = md.getMtel(mnum);
		
		return mtel;
	}

	
//	메인에서 사용할 모든 리스트 꺼내는거
	@Override
	public List<Shop> listShops() {
		
		List<Shop> listShops = null;
		try {
			listShops = md.listShops();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return listShops;
	}

	@Override
	public List<Menu> listMenu(int bnum) {
		List<Menu> menus = null;
		
		try {
			menus = md.listMenu(bnum);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return menus;
	}
}
