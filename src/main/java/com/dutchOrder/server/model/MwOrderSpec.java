package com.dutchOrder.server.model;

import java.util.Date;

import lombok.Data;

@Data
public class MwOrderSpec {
	
	private int onum;		// 주문 일련번호
	private int osnum;		// 주문상세 일련번호
	private int fnum;		// 음식번호
	private int foption_makey;
	private int foption_mikey;
	private int fcount;
	private int osprice;
}
