package com.dutchOrder.server.dao;

import com.dutchOrder.server.model.*;
import com.dutchOrder.server.model.OrderSpec;

public interface C_OrderDao {

	String getMtel(int mnum);

	void insertOrdering(Order order);

	void insertOrderSpec(OrderSpec orderspec);

	int generateOnum();

	int generateOsnum();

}
