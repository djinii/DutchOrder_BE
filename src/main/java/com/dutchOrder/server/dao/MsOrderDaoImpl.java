package com.dutchOrder.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.MsOrderSpec;
import com.dutchOrder.server.model.MsShop;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MsOrderDaoImpl implements MsOrderDao {
	// MyBatis DB 연동
	private final SqlSession session;

	@Override
	public List<MsOrderSpec> addOrderSpec() {
		System.out.println("MsOrderDaoImpl addOrderSpec Start...");
		List<MsOrderSpec> OrderList = null;
		try {
			OrderList = session.selectList("msOrderList");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return OrderList;
	}

	@Override
	public int updateOrderStatus(MsOrderSpec msOrderSpec) {
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

//	@Override
//	public int updateOrderStatus(MsShop msShop) {
//		System.out.println("MsOrderDaoImpl updateOrderStatus start..");
//		int shopOstatusUpdate= 0;
//		try {
//			session.update("updateShopStatus", msShop);
//
//		} catch (Exception e) {
//			System.out.println("updateOrderStatus Exception->" + e.getMessage());
//			e.printStackTrace();
//		}
//		return shopOstatusUpdate;
//	}
}
