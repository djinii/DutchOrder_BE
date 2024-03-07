package com.dutchOrder.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.MsOrderSpec;

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

	/*
	 * @Override public List<MsOrderSpec> addOrderStatus() {
	 * System.out.println("MsOrderDaoImpl addOrderStatus Start...");
	 * List<MsOrderSpec> OrderStatusList = null; try { OrderStatusList =
	 * session.selectList("msOrderStatusList"); } catch (Exception e) {
	 * System.out.println(e.getMessage()); } return OrderStatusList; }
	 */
}
