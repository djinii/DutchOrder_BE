package com.dutchOrder.server.dao;

import java.util.List;

import com.dutchOrder.server.model.MwOrderSpec;
import com.dutchOrder.server.model.MwOrdering;

public interface MwOrderingDao {

	List<MwOrdering> getOrdering(int mnum);

	List<MwOrderSpec> getOrderspec(int onum);

}
