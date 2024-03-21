package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.MsOrderDao;
import com.dutchOrder.server.model.OrderSpec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MsOrderServiceImpl implements MsOrderService {

	private final MsOrderDao od;

	@Override
	public int updateOrderStatus(OrderSpec msOrderSpec) {
		System.out.println("MsOrderServiceImpl updateOrderStatus start...");
		int ostatusUpdate = 0;
		System.out.println("MsOrderServiceImpl ostatusUpdate Start...");
		ostatusUpdate= od.updateOrderStatus(msOrderSpec);
		
		return ostatusUpdate;
	}
	
	@Override
	public List<OrderSpec> DetailOrder(int bnum) {
		List<OrderSpec> msOrderSpecs = null;
		System.out.println("MsOrderServiceImpl DetailOrder Start...");
		System.out.println("MsOrderServiceImpl DetailOrder bnum -> " + bnum);
		msOrderSpecs = od.OrderDetail(bnum);
		System.out.println("MsOrderServiceImpl DetailOrder msMenu -> " + msOrderSpecs);
		
		return msOrderSpecs;
	}





}
