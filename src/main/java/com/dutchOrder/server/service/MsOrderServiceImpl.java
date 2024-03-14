package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.MsOrderDao;
import com.dutchOrder.server.model.MsOrderSpec;
import com.dutchOrder.server.model.MsShop;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MsOrderServiceImpl implements MsOrderService {

	private final MsOrderDao od;

	@Override
	public List<MsOrderSpec> addOrderSpec() {
		System.out.println("MsOrderServiceImpl ShopCategoryLi Start...");
		List<MsOrderSpec> msOrderList = od.addOrderSpec();
		return msOrderList;
	}

	@Override
	public int updateOrderStatus(MsOrderSpec msOrderSpec) {
		System.out.println("MsOrderServiceImpl updateOrderStatus start...");
		int ostatusUpdate = 0;
		System.out.println("MsOrderServiceImpl ostatusUpdate Start...");
		ostatusUpdate= od.updateOrderStatus(msOrderSpec);
		
		return ostatusUpdate;
	}

//	@Override
//	public int updateShopStatus(MsShop msShop) {
//		System.out.println("MsOrderServiceImpl updateShopStatus start...");
//		int shopOstatusUpdate = 0;
//		System.out.println("MsOrderServiceImpl updateShopStatus Start...");
//		shopOstatusUpdate= od.updateOrderStatus(msShop);
//		return 0;
//	}

}
