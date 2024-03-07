package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.C_MainDaoImpl;
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

}
