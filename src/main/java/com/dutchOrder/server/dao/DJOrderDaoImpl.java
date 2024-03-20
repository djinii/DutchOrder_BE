package com.dutchOrder.server.dao;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.Order;
import com.dutchOrder.server.model.OrderSpec;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DJOrderDaoImpl implements DJOrderDao {
	private final SqlSession session;
	
	@Override
	public String getMtel(int mnum) {
		String mtel = "";
		try {
			mtel =session.selectOne("mapMtel",mnum);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		
		}
		return mtel;
	}
	// spec table
	@Override
	public void insertOrderSpec(OrderSpec orderspec) {
		System.out.println("DAO  ||| insertOrderSpec __ Start " + orderspec);
		int insertOrdSpe = 0;
		try {
			System.out.println("START INSERT++++");
			insertOrdSpe = session.insert("insertOrderSpec", orderspec);
			System.out.println(" DAO  ||| insertOrderSpec __ Fin "  + insertOrdSpe);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
	
	// ordering table
	@Override
	public void insertOrdering(Order order) {
		System.out.println("DAO  |||  insertOrdering __ start " + order);
		int insertOrd = 0;
		try {
			System.out.println("START ORDER INSERT++++");
			insertOrd = session.insert("insertOrder",order);
			System.out.println("DAO  |||  insertOrdering __ fin " + insertOrd);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public int generateOnum() {
		System.out.println("Dao || generateOnum");
		Integer onum = session.selectOne("selectMaxOnum");
	    return (onum == null) ? 1001 : onum + 1;
	}
	
	@Override
	public int generateOsnum() {
		System.out.println("Dao || generateOsnum");
		Integer osnum = session.selectOne("selectMaxOsnum");
		return (osnum == null) ? 1001 : osnum + 1;
	}
}

