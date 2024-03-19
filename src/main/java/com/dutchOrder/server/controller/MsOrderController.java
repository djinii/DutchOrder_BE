package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.MsMenu;
import com.dutchOrder.server.model.MsOrderSpec;
import com.dutchOrder.server.service.MsOrderService;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MsOrderController {

	private final MsOrderService os;

	/** 주문현황 */
//	@GetMapping("/business/{bnum}")
//	@ResponseBody
//	public List<MsOrderSpec> orderStatus(@PathVariable("bnum") String bnum) {
//	    System.out.println("MsOrderService Start OrderStatus for business number: " + bnum);
//
//	    // 여기서 주문 상태를 가져오는 메서드 호출 혹은 로직을 수행하도록 하세요.
//	    List<MsOrderSpec> resOrderSpec = os.addOrderSpec(bnum);
//
//	    System.out.println("MsOrderController List Orderlist.size() -> " + resOrderSpec.size());
//
//	    return resOrderSpec;
//	}
	
	@PostMapping("/business/orderState")
	@ResponseBody
	public List<MsOrderSpec> OrderDetail(@RequestBody MsOrderSpec msOrderSpec) {
		System.out.println("MsOrderController Start menuList ... ");
		System.out.println("MsOrderController MenuDetail msOrderSpec " + msOrderSpec);
		int bnum = msOrderSpec.getBnum();
		System.out.println("bnum-->"+bnum);
		List<MsOrderSpec> msOrderDetail = os.DetailOrder(bnum);
		
		System.out.println("MsOrderController MenuDetail Menulist -> " + msOrderDetail);
		return msOrderDetail;
	}

	/** 주문 상태 업데이트 */
	@ResponseBody
	@PostMapping("/OrderStatusUpdate")
	public int orderStatusUpdate(@RequestBody MsOrderSpec msOrderSpec) {
		System.out.println("MsOrderController Start updateOrderStatus");
		System.out.println("MsOrderController updateOrderStatus msOrderSpec " + msOrderSpec);
		int ostatusUpdate = os.updateOrderStatus(msOrderSpec);
		System.out.println("MsOrderController os.msOrderSpec msOrderSpec -> " + msOrderSpec);

		return ostatusUpdate;

	}

//		 /** 영업 상태 업데이트*/
//		@ResponseBody
//		@PostMapping("/ShopStatusUpdate")
//	  public int ShopStatusUpdate(@RequestBody MsShop msShop) {
//			System.out.println("MsOrderController Start updateShopStatus");
//			System.out.println("MsOrderController updateShopStatus msShop " + msShop);
//			int ostatusUpdate = os.updateShopStatus(msShop);
//			System.out.println("MsOrderController os.msShop msShop -> " + msShop);
//			
//			return ostatusUpdate;
//
//		}

}
