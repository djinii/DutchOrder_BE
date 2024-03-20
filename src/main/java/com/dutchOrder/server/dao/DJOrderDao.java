package com.dutchOrder.server.dao;

import com.dutchOrder.server.model.Order;
import com.dutchOrder.server.model.OrderSpec;

public interface DJOrderDao {
	String getMtel(int mnum);

	void insertOrdering(Order order);

	void insertOrderSpec(OrderSpec orderspec);

	int generateOnum();

	int generateOsnum();
}
