package com.dutchOrder.server.model;

import lombok.Data;

@Data
public class OrderSpec {
	private int onum;
	private int osnum;
	private int fnum;
	private int foption_makey;
	private int foption_mikey;
	private int fcount;			// 해당메뉴 수량
	private int osprice;		// 메뉴별 금액 
}
