package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.MsOrderDao;
import com.dutchOrder.server.model.MsOrderSpec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MsOrderServiceImpl implements MsOrderService {
	
	private final MsOrderDao od;

	@Override
	public List<MsOrderSpec> addOrderSpec() {
		System.out.println("EmpServiceImpl ShopCategoryLi Start...");
		List<MsOrderSpec> msOrderList = od.addOrderSpec();
		return msOrderList;
	}

	/*
	 * @Override public List<MsOrderSpec> getOrderStatus() {
	 * System.out.println("EmpServiceImpl addOrderStatus Start...");
	 * List<MsOrderSpec> msOrderStatusList = od.addOrderStatus(); return
	 * msOrderStatusList; }
	 */

}
