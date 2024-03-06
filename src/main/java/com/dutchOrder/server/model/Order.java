package com.dutchOrder.server.model;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
	private int mnum;			// 회원번호
	private int bnum;			// 사업자
	private int onum;			// 주문번호
	
	private String oaddr;		// 배달주소
	private String otel;		// 배달가능 연락처
	private String omsg;		// 요청사항
	private Date odate;			// 주문날짜
	private int ostatus_makey;	// 상태 대분류
	private int ostatus_mikey;	// 상태 중분류
}
