package com.dutchOrder.server.service;

import com.dutchOrder.server.model.CartReq;
import com.dutchOrder.server.model.Order;
import com.dutchOrder.server.model.OrderSpec;

public interface C_OrderService {

	void setOrdering(CartReq req, int mnum);

	String getMtel(int mnum);

//	void saveOrderAndOrderSpec(Order order, OrderSpec orderSpec);
	
}
