package com.dutchOrder.server.dao;

import java.util.List;

import com.dutchOrder.server.model.MwOrdering;
import com.dutchOrder.server.model.OrderSpec;

public interface MwOrderingDao {

	List<MwOrdering> getOrdering(int mnum);

	List<OrderSpec> getOrderspec(int onum);

}
