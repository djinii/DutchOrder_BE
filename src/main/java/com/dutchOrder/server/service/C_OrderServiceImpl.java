package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.C_OrderDao;
//import com.dutchOrder.server.model.CartInfo;
//import com.dutchOrder.server.model.CartReq;
//import com.dutchOrder.server.model.Order;
import com.dutchOrder.server.model.*;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class C_OrderServiceImpl implements C_OrderService {
	private final C_OrderDao od;
	
	@Override
	public String getMtel(int mnum) {
		System.out.println("service -----> " + mnum);
		String mtel="";
		mtel = od.getMtel(mnum);
		System.out.println("service return -----> " + mtel);
		
		return mtel;
	}
	
//	@Override
//	@Transactional
//    public void saveOrderAndOrderSpec(Order order,  OrderSpec orderSpec) {
//		od.insertOrdering(order);
//		orderSpec.setOnum(order.getOnum());
//        od.insertOrderSpec(orderSpec);
//    }

	
	
	
	
	@Override
	public void setOrdering(CartReq req, int mnum) {
//		Order ordering = new Order();
//		전달받은애 잘라서 각 객체에 set 하고 다오로 전달
		System.out.println("Service SetOrdering Start");
//		System.out.println(mnum + "@@@");
//		mnum, bnum, onum, oaddr, otel, ostatus_makey, ostatus_mike
		int result = 0;
		
		// order객체 저장
		Order ordering = new Order();
		ordering.setMnum(mnum);
		ordering.setBnum(1006);
		// 임시로
		ordering.setOnum(od.generateOnum());
		ordering.setOaddr(req.getOaddr());
		ordering.setOtel("000-1223-1234"); 		// vue에서 전
	    
		ordering.setOstatus_makey(800);
	    ordering.setOstatus_mikey(801);
		
	    System.out.println("Service _ oder : " + ordering);
	    od.insertOrdering(ordering);
	    
	    int onum = ordering.getOnum();
		
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

	}

	// 쿠키에서 mnum을 가지고 와서
}
