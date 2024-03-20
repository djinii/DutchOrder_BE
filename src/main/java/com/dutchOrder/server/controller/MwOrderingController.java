package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.OrderSpec;
import com.dutchOrder.server.model.MwOrdering;
import com.dutchOrder.server.service.MwOrderingService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MwOrderingController {

	private final MwOrderingService mwOrderingService;
	
	@PostMapping("/api/ordering")
	@ResponseBody
	public List<MwOrdering> getOrdering(@RequestBody MwOrdering mwOrdering) {
		System.out.println("컨트롤러 주문내역 불러오기 시작...");
		int mnum = mwOrdering.getMnum();
		System.out.println("mnum을 불러올까요 과연--?>"+mnum);
		List<MwOrdering> mwOrderings = mwOrderingService.getOrdering(mnum);
		System.out.println("시간은 멀까..-->"+mwOrderings);
		System.out.println("mwOrdering의 사이즈-->"+mwOrderings.size());
		
		return mwOrderings;
	}
	
	@PostMapping("/api/orderspec")
	@ResponseBody
	public List<OrderSpec> getOrderspec(@RequestBody OrderSpec mwOrderSpec) {
		System.out.println("컨트롤러 주문상세 불러오기 시작...");
		int onum = mwOrderSpec.getOnum();
		System.out.println("onum을 불러올까요 과연???-->"+onum);
		List<OrderSpec> mwOrderspecs = mwOrderingService.getOrderspec(onum);
		System.out.println("mwOrderspec의 사이즈-->"+mwOrderspecs.size());
		
		return mwOrderspecs;
		
	}
	
	
}
