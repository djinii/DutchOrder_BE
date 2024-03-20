package com.dutchOrder.server.service;

import java.util.List;

import com.dutchOrder.server.model.MwOrderSpec;
import com.dutchOrder.server.model.MwOrdering;

public interface MwOrderingService {

	List<MwOrdering> getOrdering(int mnum);

	List<MwOrderSpec> getOrderspec(int onum);

}
