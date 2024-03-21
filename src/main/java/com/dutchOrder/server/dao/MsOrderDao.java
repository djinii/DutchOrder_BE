package com.dutchOrder.server.dao;

import java.util.List;

import com.dutchOrder.server.model.OrderSpec;

public interface MsOrderDao {


	int updateOrderStatus(OrderSpec msOrderSpec);

	List<OrderSpec> OrderDetail(int bnum);


}
