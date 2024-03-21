package com.dutchOrder.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.OrderSpec;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MsOrderDaoImpl implements MsOrderDao {
	// MyBatis DB 연동
	private final SqlSession session;


	@Override
	public int updateOrderStatus(OrderSpec msOrderSpec) {
		System.out.println("MsOrderDaoImpl updateOrderStatus start..");
		int ostatusUpdate = 0;
		try {
			session.update("msOrderSpecUpdate", msOrderSpec);

		} catch (Exception e) {
			System.out.println("updateOrderStatus Exception->" + e.getMessage());
			e.printStackTrace();
		}
		return ostatusUpdate;

	}


	@Override
	public List<OrderSpec> OrderDetail(int bnum) {
		List<OrderSpec> msOrderSpecs = null;
		try {
			System.out.println("사업자 번호: "+bnum);
			msOrderSpecs = session.selectList("msOrderList", bnum);
			System.out.println("MsMenuDaoImpl MenuDetail getBnum -> " + bnum);
		} catch (Exception e) {
			System.out.println("MsMenuDaoImpl MenuDetail Exception -> " + e.getMessage());
		}
		
		return msOrderSpecs;
	}
}
