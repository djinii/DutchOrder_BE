package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.MsOrderDao;
import com.dutchOrder.server.model.MsMenu;
import com.dutchOrder.server.model.MsOrderSpec;
import com.dutchOrder.server.model.MsShop;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MsOrderServiceImpl implements MsOrderService {

	private final MsOrderDao od;

//	@Override
//	public List<MsOrderSpec> addOrderSpec(String bnum) {
//		System.out.println("MsOrderServiceImpl ShopCategoryLi Start...");
//		List<MsOrderSpec> msOrderList = od.addOrderSpec(bnum);
//		return msOrderList;
//	}

	@Override
	public int updateOrderStatus(MsOrderSpec msOrderSpec) {
		System.out.println("MsOrderServiceImpl updateOrderStatus start...");
		int ostatusUpdate = 0;
		System.out.println("MsOrderServiceImpl ostatusUpdate Start...");
		ostatusUpdate= od.updateOrderStatus(msOrderSpec);
		
		return ostatusUpdate;
	}

//	@Override
//	public List<MsOrderSpec> getOrdersByStatusAndBusiness(int ostatusMikey, String bnum) {
//	     return od.selectOrderByStatusAndBusiness(ostatusMikey, bnum);
//	    }

	
	@Override
	public List<MsOrderSpec> DetailOrder(int bnum) {
		List<MsOrderSpec> msOrderSpecs = null;
		System.out.println("MsOrderServiceImpl DetailOrder Start...");
		System.out.println("MsOrderServiceImpl DetailOrder bnum -> " + bnum);
		msOrderSpecs = od.OrderDetail(bnum);
		System.out.println("MsOrderServiceImpl DetailOrder msMenu -> " + msOrderSpecs);
		
		return msOrderSpecs;
	}





}
