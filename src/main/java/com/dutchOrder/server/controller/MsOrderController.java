package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.MsOrderSpec;
import com.dutchOrder.server.service.MsOrderService;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MsOrderController {

	private final MsOrderService os;

	// 주문현황
	@GetMapping("/B_Ordering")
	@ResponseBody
	public List<MsOrderSpec> orderStatus() {

		System.out.println("MsOrderService Start OrderStatus ... ");

		List<MsOrderSpec> resOrderSpec = os.addOrderSpec();

		System.out.println("MsOrderController List Orderlist.size() -> " + resOrderSpec.size());

		return resOrderSpec;

	}

	  // 주문 상태 
		@PostMapping(value = "StatusUpdate")
	  public String orderStatusUpdate(MsOrderSpec orderSpec, Model model) {
			System.out.println("orderStatusUpdate Start...");
			
//			MsOrderSpec orderSpec = os.detailMsOrder(orderSpec.getOnum());
			System.out.println("emp.getOnum()->" + orderSpec.getOnum());
			System.out.println("emp.getHiredate()->" + orderSpec.getOstatus_mikey());
			
//			System.out.println("hiredate->" + hiredate);
//
//			model.addAttribute("emp", emp);

			return "StatusUpdate";
		}
		

}
