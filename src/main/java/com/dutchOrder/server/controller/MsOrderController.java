package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.OrderSpec;
import com.dutchOrder.server.service.MsOrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MsOrderController {

	private final MsOrderService os;

	/** 주문현황 */
	@PostMapping("/business/home")
	@ResponseBody
	public List<OrderSpec> OrderDetail(@RequestBody OrderSpec msOrderSpec) {
		System.out.println("MsOrderController Start menuList ... ");
		System.out.println("MsOrderController MenuDetail msOrderSpec " + msOrderSpec);
		int bnum = msOrderSpec.getBnum();
		System.out.println("bnum-->"+bnum);
		List<OrderSpec> msOrderDetail = os.DetailOrder(bnum);
		
		System.out.println("MsOrderController MenuDetail Menulist -> " + msOrderDetail);
		return msOrderDetail;
	}

	/** 주문 상태 업데이트 */
	@ResponseBody
	@PostMapping("/OrderStatusUpdate")
	public int orderStatusUpdate(@RequestBody OrderSpec msOrderSpec) {
		System.out.println("MsOrderController Start updateOrderStatus");
		System.out.println("MsOrderController updateOrderStatus msOrderSpec " + msOrderSpec);
		int ostatusUpdate = os.updateOrderStatus(msOrderSpec);
		System.out.println("MsOrderController os.msOrderSpec msOrderSpec -> " + msOrderSpec);

		return ostatusUpdate;

	}


}
