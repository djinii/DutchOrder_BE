package com.dutchOrder.server.dao;

import java.util.List;

import com.dutchOrder.server.model.MsOrderSpec;
import com.dutchOrder.server.model.MsShop;

public interface MsOrderDao {

	// List<MsOrderSpec> addOrderSpec();
	
	//List<MsOrderSpec> selectOrderByStatusAndBusiness(int ostatusMikey, String bnum);

	int updateOrderStatus(MsOrderSpec msOrderSpec);

	List<MsOrderSpec> OrderDetail(int bnum);

	//List<MsOrderSpec> addOrderSpec(String bnum);

//	int updateOrderStatus(MsShop msShop);


}
