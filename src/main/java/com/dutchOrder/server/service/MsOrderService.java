package com.dutchOrder.server.service;

import java.util.List;

import com.dutchOrder.server.model.OrderSpec;

public interface MsOrderService {

	int updateOrderStatus(OrderSpec msOrderSpec);

	List<OrderSpec> DetailOrder(int bnum);
}
