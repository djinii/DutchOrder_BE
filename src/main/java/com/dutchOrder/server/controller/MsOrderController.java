package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.MsOrderSpec;
import com.dutchOrder.server.model.MsShop;
import com.dutchOrder.server.service.MsOrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MsOrderController {

	private final MsOrderService os;

	/** 주문현황 */
	@GetMapping("/B_Ordering")
	@ResponseBody
	public List<MsOrderSpec> orderStatus() {

		System.out.println("MsOrderService Start OrderStatus ... ");

		List<MsOrderSpec> resOrderSpec = os.addOrderSpec();

		System.out.println("MsOrderController List Orderlist.size() -> " + resOrderSpec.size());

		return resOrderSpec;

	}

	 /** 주문 상태 업데이트*/
		@ResponseBody
		@PostMapping("/StatusUpdate")
	  public int orderStatusUpdate(@RequestBody MsOrderSpec msOrderSpec) {
			System.out.println("MsOrderController Start updateOrderStatus");
			System.out.println("MsOrderController updateOrderStatus msOrderSpec " + msOrderSpec);
			int ostatusUpdate = os.updateOrderStatus(msOrderSpec);
			System.out.println("MsOrderController os.msOrderSpec msOrderSpec -> " + msOrderSpec);
			
			return ostatusUpdate;

		}
		
		 /** 영업 상태 업데이트*/
		@ResponseBody
		@PostMapping("/ShopStatusUpdate")
	  public int ShopStatusUpdate(@RequestBody MsShop msShop) {
			System.out.println("MsOrderController Start updateShopStatus");
			System.out.println("MsOrderController updateShopStatus msShop " + msShop);
			int ostatusUpdate = os.updateShopStatus(msShop);
			System.out.println("MsOrderController os.msShop msShop -> " + msShop);
			
			return ostatusUpdate;

		}


}
