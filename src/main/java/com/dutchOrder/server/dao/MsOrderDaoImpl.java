package com.dutchOrder.server.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.MsMenu;
import com.dutchOrder.server.model.MsOrderSpec;
import com.dutchOrder.server.model.MsShop;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MsOrderDaoImpl implements MsOrderDao {
	// MyBatis DB 연동
	private final SqlSession session;

//	@Override
//	public List<MsOrderSpec> addOrderSpec(String bnum) {
//		System.out.println("MsOrderDaoImpl addOrderSpec Start...");
//		List<MsOrderSpec> OrderList = null;
//		try {
//			OrderList = session.selectList("msOrderList", bnum);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return OrderList;
//		
//		
//	}

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
//	public List<MsOrderSpec> selectOrderByStatusAndBusiness(int ostatusMikey, String bnum) {
//		  Map<String, Object> params = new HashMap<>();
//		  params.put("ostatusMikey", ostatusMikey);
//		    params.put("bnum", bnum);
//		
//		List<MsOrderSpec> results = session.selectList("msOrderList", params);
//	    return results;
//	}

	@Override
	public List<MsOrderSpec> OrderDetail(int bnum) {
		List<MsOrderSpec> msOrderSpecs = null;
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
