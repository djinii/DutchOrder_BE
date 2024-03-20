package com.dutchOrder.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.OrderSpec;
import com.dutchOrder.server.model.MwOrdering;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MwOrderingDaoImpl implements MwOrderingDao {

	private final SqlSession session;

	@Override
	public List<MwOrdering> getOrdering(int mnum) {
		System.out.println("다오 주문내역 불러오기 시작...");
		List<MwOrdering> mwOrderings = session.selectList("mwOrderings", mnum);
		return mwOrderings;
	}

	@Override
	public List<OrderSpec> getOrderspec(int onum) {
		System.out.println("다오 주문상세 불러오기 시작...");
		List<OrderSpec> mwOrderspecs = session.selectList("mwOrderspecs", onum);
		return mwOrderspecs;
	}
	
}
