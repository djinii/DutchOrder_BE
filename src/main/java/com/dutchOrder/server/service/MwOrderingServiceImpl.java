package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.MwOrderingDao;
import com.dutchOrder.server.model.OrderSpec;
import com.dutchOrder.server.model.MwOrdering;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MwOrderingServiceImpl implements MwOrderingService {

	private final MwOrderingDao mwOrderingDao;

	@Override
	public List<MwOrdering> getOrdering(int mnum) {
		System.out.println("서비스 주문내역 불러오기 시작...");
		List<MwOrdering> mwOrderings = mwOrderingDao.getOrdering(mnum);
		return mwOrderings;
	}

	@Override
	public List<OrderSpec> getOrderspec(int onum) {
		System.out.println("서비스 주문상세 불러오기 시작...");
		List<OrderSpec> mwOrderspecs = mwOrderingDao.getOrderspec(onum);
		return mwOrderspecs;
	}
	
}
