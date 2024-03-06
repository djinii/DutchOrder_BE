package com.dutchOrder.server.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.MsMenuDao;
import com.dutchOrder.server.model.MsMenu;
import com.dutchOrder.server.model.MsShop;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MsMenuServiceImpl implements MsMenuService {

	private final MsMenuDao md;

//	@Override
//	public List<String> ShopCategoryLi(int fcategory_mikey) {
//		List<String> shopList = null;
//		System.out.println("MsMenuServiceImpl ShopCategoryLi Start...");
//		System.out.println("MsMenuServiceImpl ShopCategoryLi fcategory_mikey -> " + fcategory_mikey);
//		shopList = md.ShopCategoryLi(fcategory_mikey);
//		System.out.println("MsMenuServiceImpl ShopCategoryLi shopList -> " + shopList);
//
//		return shopList;
//	}

//	@Override
//	public Notice noticeDetail(int nonum) {
//		Notice notice = null;
//		System.out.println("NoticeServiceImpl noticeDetail Start...");
//		System.out.println("NoticeServiceImpl noticeDetail nonum -> " + nonum);
//		notice = nd.noticeDetail(nonum);
//		System.out.println("NoticeServeImpl noticeDetail notice -> " + notice);
//
//		return notice;
//	}

	@Override
	public List<MsMenu> MsMenulist(MsMenu msMenu) {
		List<MsMenu> menuList = null;
		System.out.println("EmpServiceImpl deptSelect Start...");
		menuList = md.MsSelectMenu(msMenu);
		System.out.println("EmpServiceImpl deptSelect deptList.size()->" + menuList.size());

		return menuList;
	}

	@Override
	public List<MsShop> ShopCategoryLi() {
		System.out.println("start ");
		List<MsShop> msShopList = md.ShopCategoryLi();
		return msShopList;
	}

}
