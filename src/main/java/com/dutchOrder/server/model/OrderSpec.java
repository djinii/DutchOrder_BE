package com.dutchOrder.server.model;

import lombok.Data;

@Data
public class OrderSpec {
	
	private int onum;		// 주문 일련번호
	private int osnum;		// 주문상세 일련번호
	private int fnum;		// 음식번호
	private int foption_makey;
	private int foption_mikey;
	private int fcount;		// 해당메뉴 수량
	private int osprice;	// 메뉴별 금액 
	private String fname;
	private String keyvalue;
}
