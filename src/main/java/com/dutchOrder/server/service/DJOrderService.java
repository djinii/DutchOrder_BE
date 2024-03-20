package com.dutchOrder.server.service;

import com.dutchOrder.server.model.CartReq;

public interface DJOrderService {
	int setOrdering(CartReq req, int mnum);
}
