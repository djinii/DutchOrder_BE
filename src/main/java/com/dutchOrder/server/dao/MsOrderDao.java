package com.dutchOrder.server.dao;

import java.util.List;

import com.dutchOrder.server.model.MsOrderSpec;
import com.dutchOrder.server.model.MsShop;

public interface MsOrderDao {

	List<MsOrderSpec> addOrderSpec();

	int updateOrderStatus(MsOrderSpec msOrderSpec);

//	int updateOrderStatus(MsShop msShop);


}
