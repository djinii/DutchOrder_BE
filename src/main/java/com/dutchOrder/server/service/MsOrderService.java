package com.dutchOrder.server.service;

import java.util.List;

import com.dutchOrder.server.model.MsOrderSpec;
import com.dutchOrder.server.model.MsShop;

public interface MsOrderService {


	//List<MsOrderSpec> addOrderSpec();

	int updateOrderStatus(MsOrderSpec msOrderSpec);

	//List<MsOrderSpec> addOrderSpec(String bnum);
	
	  // List<MsOrderSpec> getOrdersByStatusAndBusiness(int ostatusMikey, String bnum);

	List<MsOrderSpec> DetailOrder(int bnum);
	}

