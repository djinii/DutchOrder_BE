package com.dutchOrder.server.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dutchOrder.server.dao.DJOrderDao;
import com.dutchOrder.server.model.CartInfo;
import com.dutchOrder.server.model.CartReq;
import com.dutchOrder.server.model.Order;
import com.dutchOrder.server.model.OrderSpec;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DJOrderServiceImpl implements DJOrderService {
	
	private final DJOrderDao od;
	
	
//	onum return받아야함
	@Override
	public int setOrdering(CartReq req, int mnum) {
		System.out.println("Service SetOrdering Start");

		int result = 0;
		
		// order객체 저장
		Order ordering = new Order();
		ordering.setMnum(mnum);

		ordering.setBnum(1006);
//		ordering.setBnum(req.getBnum());

		ordering.setOnum(od.generateOnum());
		ordering.setOaddr(req.getOaddr());
		
//		ordering.setOtel(req.getOtel());
		ordering.setOtel("000-1223-1234"); 		// vue에서 전달받아야함
	    
		ordering.setOstatus_makey(800);
	    ordering.setOstatus_mikey(801);
		
	    System.out.println("Service _ oder : " + ordering);
	    od.insertOrdering(ordering);
	    
	    int onum = ordering.getOnum();
		System.out.println(onum + "  new onum");
	    
		// orderSpec 저장
		List<CartInfo> cartInfos = req.getCart();
		for (CartInfo cartInfo : cartInfos) {
		    OrderSpec orderSpec = new OrderSpec();
		    
		    orderSpec.setOnum(onum);
		    orderSpec.setOsnum(od.generateOsnum());
		    orderSpec.setFnum(cartInfo.getFnum());
		    orderSpec.setFoption_makey(1100);
		    orderSpec.setFoption_mikey(cartInfo.getFoption_mikey());
		    orderSpec.setFcount(cartInfo.getFcount());
		    orderSpec.setOsprice(cartInfo.getOsprice());
		    
		    System.out.println("Service _ OrderSPec : " + orderSpec);

		    od.insertOrderSpec(orderSpec);
		    
		}		
		
		System.out.println("Service : Fin");
		
		return onum;
	}

}
