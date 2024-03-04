package com.dutchOrder.server.model;

import java.util.Date;

import lombok.Data;

@Data
public class MwOrderSpec {
	private int mnum;		// 회원 일련번호
	private int bnum;		// 사업자 일련번호
	private int onum;		// 주문 일련번호
	private int osnum;		// 주문상세 일련번호
	private int fnum;		// 음식번호
	private int osmem;		// 친구 일련번호
	private Date osdate;	// 주문 날짜
}
