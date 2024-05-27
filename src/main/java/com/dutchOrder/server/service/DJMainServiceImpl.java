package com.dutchOrder.server.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.DJMainDao;
import com.dutchOrder.server.model.*;

import ch.qos.logback.core.joran.action.TimestampAction;
import io.micrometer.observation.annotation.Observed;
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

	// ------------------------------------------------------------------------------------- //
	@Override
	public int regAddress(Address address) {					// 주소 등록
		int result = 0;
		try {
			
			Timestamp currTimestamp = new Timestamp(System.currentTimeMillis());
			address.setAdLatest_date(currTimestamp);
			
			String adnum = md.createAdNum(address.getMnum());
			address.setAdnum(adnum);
			
			System.out.println(address + " ============> 저장해야할 주소 객체");
			
			result = md.regAddress(address);
			System.out.println("저장완료? from 다오 -> " + result);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return 0;
	}

	@Override
	public List<Shop> nearbyShops(Double x, Double y) {				// 근처 가게 리스트
		List<Shop> nearbyShops = null;
		SearchCriteria searchCriteria = new SearchCriteria();		// 검색 조건으로 사용할 min, max 좌표 값

		try {	
			searchCriteria.setMin_x(x - 0.005);
			searchCriteria.setMax_x(x + 0.005);
			searchCriteria.setMin_y(y - 0.005);
			searchCriteria.setMax_y(y + 0.005);
			
			System.err.println(searchCriteria + "0000000000000000000");
			
			nearbyShops = md.nearbyShops(searchCriteria);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return nearbyShops;
	}

	@Override
	public List<Address> myAddrList(String mnum) {
		System.out.println(mnum + "mainService +  " + mnum);
		List<Address> listAddr = md.myAddrList(mnum);
		System.out.println("finished  listAddr --> " + listAddr);
		return listAddr;
	}
	
}
