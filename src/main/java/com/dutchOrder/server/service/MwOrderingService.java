package com.dutchOrder.server.service;

import java.util.List;

import com.dutchOrder.server.model.OrderSpec;
import com.dutchOrder.server.model.MwOrdering;

public interface MwOrderingService {

	List<MwOrdering> getOrdering(int mnum);

	List<OrderSpec> getOrderspec(int onum);

}
